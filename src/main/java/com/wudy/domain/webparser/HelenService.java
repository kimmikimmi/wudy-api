package com.wudy.domain.webparser;

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

	public List<ArticleDto> getArticleListInHorizontal(Long timeStamp) {
		List<String> urlList = richWudy.getUrlListInHorizontal(HORIZONTAL_SIZE, timeStamp);
		return webParsingService.getArticleInfoList(urlList);
	}

	public List<ArticleDto> getArticleListInVertical(String url, Long timeStamp) {
		List<String> urlList = richWudy.getUrlListInVertical(url, VERTICAL_SIZE, timeStamp);
		return webParsingService.getArticleInfoList(urlList);
	}
}
