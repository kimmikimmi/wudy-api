package com.wudy.wudy_interface;

import com.wudy.common.WudyResponse;
import com.wudy.domain.webparser.BeckyService;
import com.wudy.domain.webparser.dao.RichWudy;
import com.wudy.domain.webparser.dto.ArticleDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.List;


/**
 * @author : Jaden
 * @since : 01/07/2017
 */
@Slf4j
@RestController
@RequestMapping(value = "/article")
public class BackController {

	private static final String FILE_PATH_LOCAL = "/Users/Jaden/";
	private static final String FILE_NAME = "article";

	private final BeckyService beckyService;
	private final RichWudy richWudy;

	public BackController(BeckyService beckyService, RichWudy richWudy) {
		this.beckyService = beckyService;
		this.richWudy = richWudy;
	}

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public WudyResponse saveUrlList(@RequestParam MultipartFile urlFile) throws IOException {

		log.debug("fileName :  {}", urlFile.getName());

		File dest = new File(FILE_PATH_LOCAL + FILE_NAME);
		urlFile.transferTo(dest);
		log.info("file write success {}", dest.getAbsolutePath());


		List<ArticleDto> articles = beckyService.getArticleList(dest);
		/**
		 * articles를  hbase 에 데이터를 적재하는 로직이 들어가야 한다.
		 */



		return new WudyResponse();
	}


}
