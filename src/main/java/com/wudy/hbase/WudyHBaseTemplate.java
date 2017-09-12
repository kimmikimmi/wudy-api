package com.wudy.hbase;

import com.wudy.hbase.constants.HBaseTableInfo;

/**
 * Created by naver on 2017. 7. 05.
 */
public interface WudyHBaseTemplate {
	public void put(HBaseTableInfo hBaseTableInfo, String rowKey, Object value);

	public <T> T get(HBaseTableInfo hBaseTableInfo, String rowKey, Class<T> classType);
}
