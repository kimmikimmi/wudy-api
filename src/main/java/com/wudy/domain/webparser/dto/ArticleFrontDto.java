package com.wudy.domain.webparser.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */

@Builder
@Getter
public class ArticleFrontDto {
		private String url;
		private String title;
		private String summary;
		private String thumbnail;

}
