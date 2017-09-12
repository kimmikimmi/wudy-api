package com.wudy.domain.webparser;

import com.google.common.collect.Lists;
import com.wudy.domain.webparser.dao.RichWudy;
import com.wudy.domain.webparser.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */

@Slf4j
@Service
public class HelenService {

	private final WebParsingService webParsingService;
	private final RichWudy richWudy;

	private static final int HORIZONTAL_SIZE = 5;
	private static final int VERTICAL_SIZE = 3;

	@Autowired
	public HelenService(WebParsingService webParsingService, RichWudy richWudy ) {
		this.webParsingService = webParsingService;
		this.richWudy = richWudy;
	}

	/**
	 *
	 * @param timeStamp
	 * @return List<articleDto>
	 */
	public List<ArticleDto> getArticleListInHorizontal(Long timeStamp) {
//		return richWudy.getUrlListInHorizontal(HORIZONTAL_SIZE, timeStamp);
		List<String> urls = Lists.newArrayList();
		final String url1 = "http://entertain.naver.com/read?oid=109&aid=0003252603";
		final String url2 = "http://entertain.naver.com/read?oid=109&aid=0003252602";
		final String url3 =  "http://entertain.naver.com/read?oid=421&aid=0001869876";
		final String url4 = "http://entertain.naver.com/read?oid=311&aid=0000572891";
		final String url5 = "http://entertain.naver.com/read?oid=416&aid=0000177273";

		urls.add(url1);
		urls.add(url2);
		urls.add(url3);
		urls.add(url4);
		urls.add(url4);
		urls.add(url5);

		return webParsingService.getArticleInfoList(urls);
	}

	public List<ArticleDto> getArticleListInVertical(String url, Long timeStamp) {
//		return richWudy.getUrlListInVertical(url, VERTICAL_SIZE, timeStamp);
		List<String> urls = Lists.newArrayList();

		final String url1 = "http://entertain.naver.com/read?oid=213&aid=0000841073";
		final String url2 = "http://entertain.naver.com/read?oid=109&aid=0003252599";
		final String url3 = "http://entertain.naver.com/read?oid=109&aid=0003252598";

		urls.add(url1);
		urls.add(url2);
		urls.add(url3);

		return webParsingService.getArticleInfoList(urls);
	}
}
