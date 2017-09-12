package com.wudy.hbase.serializer;

import java.nio.charset.Charset;

import org.springframework.stereotype.Component;

/**
 * Created by naver on 2017. 7. 05.
 */
@Component
public class HBaseStringSerializer implements HBaseSerializer<String> {
	private final Charset charset = Charset.forName("UTF8");

	@Override
	public byte[] serialize(String string) {
		return string == null ? null : string.getBytes(this.charset);
	}

	@Override
	public String deserialize(byte[] bytes) {
		return bytes == null ? null : new String(bytes, this.charset);
	}
}
