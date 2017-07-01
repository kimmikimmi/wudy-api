package com.wudy.wudy_interface;

import com.wudy.common.WudyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

	@RequestMapping(value = "/file", method = RequestMethod.POST)
	public WudyResponse saveUrlList(@RequestParam MultipartFile urlList) throws IOException {

		log.debug("fileName :  {}", urlList.getName());

		File dest = new File(FILE_PATH_LOCAL + FILE_NAME);
		urlList.transferTo(dest);
		log.info("file write success {}", dest.getAbsolutePath());

		return new WudyResponse();
	}

}
