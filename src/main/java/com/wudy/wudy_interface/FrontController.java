package com.wudy.wudy_interface;

import com.google.common.base.Preconditions;
import com.wudy.domain.webparser.HelenService;

import com.wudy.domain.webparser.dto.ArticleDto;

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
public class FrontController {

	private final HelenService helenService;

	@Autowired
	FrontController(HelenService helenService) {

		this.helenService = helenService;
	}

	@RequestMapping(value = "/horizontal/v1", method = RequestMethod.POST)
	public List<ArticleDto> getArticleInHorizontal(@RequestParam Long timeStamp, @RequestParam String userToken) {
		Preconditions.checkNotNull(timeStamp, "timeStamp is null");
		Preconditions.checkNotNull(userToken, "userToken is null");

		/*userStamp 로 개인정보 저장하는 로직 추가*/
		return helenService.getArticleListInHorizontal(timeStamp);
	}

	@RequestMapping(value = "/vertical/v1", method = RequestMethod.POST)
	public List<ArticleDto> getArticleInVertical(@RequestParam String url, @RequestParam Long timeStamp, @RequestParam String userToken) {
		Preconditions.checkNotNull(timeStamp, "timeStamp is null");
		Preconditions.checkNotNull(userToken, "userToken is null");

		/*userStamp 로 개인정보 저장하는 로직 추가*/
		return helenService.getArticleListInVertical(url, timeStamp);
	}

}
