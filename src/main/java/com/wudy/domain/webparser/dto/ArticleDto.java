package com.wudy.domain.webparser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Builder
@Getter
@Setter
public class ArticleDto {

	String title;
	String summary;
	String body;
	String category;
	String author;
	String url;
	String modifiedDate;
	String createdDate;
	String thumbnail;
}
