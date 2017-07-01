package com.wudy.domain.webparser;

import lombok.Getter;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
public enum OpenGraphProperties {
	TITLE("title", "제목"),
	TYPE("type", "타입"),
	DESCRIPTION("description", "설명"),
	AUTHOR("article:author", "저자");

	@Getter
	private String value;

	@Getter
	private String desc;

	OpenGraphProperties(String value, String des) {
		this.value = value;
		this.desc = des;
	}
}
