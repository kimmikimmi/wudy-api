package com.wudy.hbase.constants;

import org.apache.hadoop.hbase.util.Bytes;

import lombok.Getter;

/**
 * Created by naver on 2017. 7. 05.
 */
@Getter
public enum HBaseTableInfo {
	ARTICLE("article", Bytes.toBytes("g"), Bytes.toBytes("a"));

	String tableName;
	byte[] family;
	byte[] qualifier;

	HBaseTableInfo(String tableName, byte[] family, byte[] qualifier) {
		this.tableName = tableName;
		this.family = family;
		this.qualifier = qualifier;
	}
}
