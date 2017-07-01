package com.wudy.domain.webparser;

import com.google.common.collect.Lists;
import com.wudy.domain.webparser.dao.RichWudy;
import com.wudy.domain.webparser.dto.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Service
public class HelenService {

	private final WebParsingService webParsingService;
	private final RichWudy richWudy;

	private static final int HORIZONTAL_SIZE = 10;
	private static final int VERTICAL_SIZE = 3;

	@Autowired
	public HelenService(WebParsingService webParsingService, RichWudy richWudy) {
		this.webParsingService = webParsingService;
		this.richWudy = richWudy;
	}

	//TODO : hadoop client 에서 데이터를 읽어와
	public List<ArticleDto> getArticleListInHorizontal(Long timeStamp) {
		return richWudy.getUrlListInHorizontal(HORIZONTAL_SIZE, timeStamp);
	}

	public List<ArticleDto> getArticleListInVertical(String url, Long timeStamp) {
		return richWudy.getUrlListInVertical(url, VERTICAL_SIZE, timeStamp);

	}
}
