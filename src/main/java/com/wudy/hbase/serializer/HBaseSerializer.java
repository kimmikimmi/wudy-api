package com.wudy.hbase.serializer;

/**
 * Created by naver on 2017. 7. 05.
 */
public interface HBaseSerializer<T> {
	byte[] serialize(T t);

	T deserialize(byte[] bytes);
}
