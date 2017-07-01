package com.wudy.domain.webparser;

import com.wudy.domain.webparser.dto.ArticleDto;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
public interface WebParsingService {
	ArticleDto getArticleInfo(final String url) throws Exception;

	List<ArticleDto> getArticleInfos(final List<String> urls );
}
