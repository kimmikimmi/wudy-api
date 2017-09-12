package com.wudy.domain.webparser;

import com.wudy.domain.webparser.dao.RichWudy;
import com.wudy.domain.webparser.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Slf4j
@Service
public class WebParsingServiceImpl implements WebParsingService {


	private final WebParsingFactory webParsingFactory;

	@Autowired
	public WebParsingServiceImpl(WebParsingFactory webParsingFactory) {
		this.webParsingFactory = webParsingFactory;

	}

	public ArticleDto getArticleInfo(final String url)  {

		webParsingFactory.setUrlPath(url);

		String title = "";
		String type = "";
		String author = "";
		String description = "";
		String thumbnail = "";
		String body = "";
		String createdDate = "";
		String modifiedDate = "";

		try {
			createdDate = webParsingFactory.getCreatedDate();
			modifiedDate = webParsingFactory.getModifiedDate();
			body = webParsingFactory.getBody();
			title = webParsingFactory.getProperty(OpenGraphProperties.TITLE);
			type = webParsingFactory.getProperty(OpenGraphProperties.TYPE);
			author = webParsingFactory.getProperty(OpenGraphProperties.AUTHOR);
			description = webParsingFactory.getProperty(OpenGraphProperties.DESCRIPTION);
			thumbnail = webParsingFactory.getProperty(OpenGraphProperties.THUMNAIL);
		} catch (Exception e) {
			log.error("fail to parse open graph tags {}", e);
		}

		return ArticleDto.builder()
			.author(author)
			.category(type)
			.summary(description)
			.title(title)
			.url(url)
			.thumbnail(thumbnail)
			.body(body)
			.modifiedDate(modifiedDate)
			.createdDate(createdDate)
			.build();

	}

	public List<ArticleDto> getArticleInfoList(final List<String> urls ) {
		return urls.stream()
			.map(this::getArticleInfo)
			.collect(Collectors.toList());

	}
}
