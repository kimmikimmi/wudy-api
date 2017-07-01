package com.wudy.wudy_interface;

import com.google.common.collect.Lists;
import com.wudy.domain.webparser.WebParsingService;
import com.wudy.domain.webparser.dto.ArticleFrontDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@RestController
@Slf4j
@RequestMapping(value = "/api/article")
public class ArticleFrontController {

	private final WebParsingService webParsingService;

	@Autowired
	ArticleFrontController(WebParsingService webParsingService) {
		this.webParsingService = webParsingService;
	}

	@RequestMapping(value = "/horizontal/v1", method = RequestMethod.POST)
	public List<ArticleFrontDto> getArticleInHorizontalWay(@RequestParam Long timeStamp, @RequestParam String userToken) {
		return Lists.newArrayList();
	}

	@RequestMapping(value = "/vertical/v1", method = RequestMethod.POST)
	public List<ArticleFrontDto> getArticleInVerticalWay(@RequestParam Long timeStamp, @RequestParam String userToken) {

		return Lists.newArrayList();
	}

}
