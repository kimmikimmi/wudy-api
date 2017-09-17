package com.wudy.hbase;

import static org.apache.hadoop.hbase.HConstants.*;

import java.util.Collection;
import java.util.Map;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.GenericTypeResolver;

import com.google.common.collect.Maps;
import com.wudy.hbase.constants.HBaseTableInfo;
import com.wudy.hbase.serializer.HBaseSerializer;

//@Component
public class WudyHBaseClient implements InitializingBean, DisposableBean, WudyHBaseTemplate {
	@Value("${zookeeper.connect.string}")
	String quorumString;

	@Autowired
	ApplicationContext applicationContext;

	private Connection connection;

	Map<Class<?>, HBaseSerializer<?>> serializerCache = Maps.newHashMap();

	public void put(HBaseTableInfo hBaseTableInfo, String rowKey, Object value) {
		try (final Table table = connection.getTable(TableName.valueOf(hBaseTableInfo.getTableName()))) {

			HBaseSerializer serializer = getHBaseSerializer(value.getClass());
			byte[] b = serializer.serialize(value);

			final Put put = new Put(Bytes.toBytes(rowKey)).addColumn(hBaseTableInfo.getFamily(), hBaseTableInfo.getQualifier(), b);
			table.put(put);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public <T> T get(HBaseTableInfo hBaseTableInfo, String rowKey, Class<T> classType) {
		try (final Table table = connection.getTable(TableName.valueOf(hBaseTableInfo.getTableName()))) {
			final Get get = new Get(Bytes.toBytes(rowKey)).addColumn(hBaseTableInfo.getFamily(), hBaseTableInfo.getQualifier());
			final Result result = table.get(get);

			byte[] b = result.getValue(hBaseTableInfo.getFamily(), hBaseTableInfo.getQualifier());

			HBaseSerializer<T> serializer = getHBaseSerializer(classType);
			return serializer.deserialize(b);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private <T> HBaseSerializer<T> getHBaseSerializer(Class<T> classType) {
		HBaseSerializer serializer = serializerCache.get(classType);
		if (serializer == null) {
			throw new RuntimeException("HBase serializer not exist, classType : " + classType);
		}

		return serializer;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		final Configuration configuration = HBaseConfiguration.create();
		configuration.set(ZOOKEEPER_QUORUM, quorumString);
		this.connection = ConnectionFactory.createConnection(configuration);

		Collection<HBaseSerializer> hBaseSerializers = applicationContext.getBeansOfType(HBaseSerializer.class).values();

		for (HBaseSerializer hBaseSerializer : hBaseSerializers) {
			Class classType = GenericTypeResolver.resolveTypeArgument(AopUtils.getTargetClass(hBaseSerializer), HBaseSerializer.class);
			if (serializerCache.put(classType, hBaseSerializer) != null) {
				throw new IllegalArgumentException("Do not permit multiple hBaseSerializer on classType: " + hBaseSerializer + ", " + classType);
			}

		}
	}

	@Override
	public void destroy() throws Exception {
		this.connection.close();
	}
}
