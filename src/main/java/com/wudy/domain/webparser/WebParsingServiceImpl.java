package com.wudy.domain.webparser;

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
		String content = webParsingFactory.getHtmlContent() == null ? "" : webParsingFactory.getHtmlContent();

		String title = "";
		String type = "";
		String author = "";
		String description = "";

		try {
			title = webParsingFactory.getProperty(OpenGraphProperties.TITLE);
			type = webParsingFactory.getProperty(OpenGraphProperties.TYPE);
			author = webParsingFactory.getProperty(OpenGraphProperties.AUTHOR);
			description = webParsingFactory.getProperty(OpenGraphProperties.DESCRIPTION);

		} catch (Exception e) {
			log.error("fail to parse open graph tags {}", e);
		}

		return ArticleDto.builder()
			.author(author)
			.category(type)
			.summary(description)
			.title(title)
			.url(url)
			//			.creator()
			//			.modifiedAt()
			//			.description()
			.build();

	}

	public List<ArticleDto> getArticleInfos(final List<String> urls ) {
		return urls.stream()
			.filter(this::isValidUrl)
			.map(this::getArticleInfo)
			.collect(Collectors.toList());

	}

	/**
	 * 실제로 정제되지 않은 url이 들어오는 경우도 있으므로 수정이 필요.
	 * @param url
	 * @return 가치가 있는 url 여부
	 */
	private boolean isValidUrl(final String url) {
		return StringUtils.isEmpty(isValidUrl(url));
	}

	public static void main(String[] args) throws Exception {
		WebParsingServiceImpl webParsingService = new WebParsingServiceImpl(new WebParsingFactory());
		webParsingService.getArticleInfo("http://entertain.naver.com/read?oid=312&aid=0000237088");
	}
}
