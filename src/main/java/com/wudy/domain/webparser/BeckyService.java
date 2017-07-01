package com.wudy.domain.webparser;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.wudy.domain.webparser.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : Jaden
 * @since : 02/07/2017
 */
@Service
@Slf4j
public class BeckyService {

	private final WebParsingService webParsingService;

	public BeckyService(WebParsingService webParsingService) {
		this.webParsingService = webParsingService;
	}

	private List<String> getUrlList(File file) {

		try (Stream<String> lines = Files.lines(file.toPath(), Charset.defaultCharset())) {
			return lines.filter(this::isValidUrl).collect(Collectors.toList());
		} catch (IOException e) {
			log.error("An exception occurs {}", e);
			return Lists.newArrayList();
		}
	}

	public List<ArticleDto> getArticleList(File urlFile) {
		Preconditions.checkNotNull(urlFile, "urls is null");

		return webParsingService.getArticleInfoList(getUrlList(urlFile));
	}

	private boolean isValidUrl(final String url) {
		return !StringUtils.isEmpty(isValidUrl(url)) &&
			url.contains("entertain.naver.com") &&
			url.contains("oid") &&
			url.contains("aid");
	}

}
