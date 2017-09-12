package com.wudy.domain.webparser.dao;

import com.wudy.domain.webparser.dto.ArticleDto;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
public interface RichWudy {

	List<ArticleDto> getUrlListInHorizontal(int size, Long timeStamp);

	List<ArticleDto> getUrlListInVertical(String url, int size, Long timeStamp);
}
