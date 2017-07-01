package com.wudy;

import com.wudy.common.WudyResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@SpringBootApplication
@RestController
@Slf4j
public class WudyApiApplication {

	@RequestMapping(value = "/article", method = RequestMethod.POST)
	public WudyResponse article(@RequestParam MultipartFile urlList) throws IOException {
		System.out.println(urlList);
		String uuid = UUID.fromString(urlList.getOriginalFilename()).toString();
		File dest = new File("/home/ubuntu/tmp/"+uuid);

		urlList.transferTo(dest);
		log.info("file write success {}", dest.getAbsolutePath());
		return new WudyResponse();
	}

	public static void main(String[] args) {

		System.out.println("Hello World!!!!!");
		SpringApplication.run(WudyApiApplication.class, args);
	}
}
