package com.wudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;



@SpringBootApplication
@RestController
@Slf4j
public class WudyApiApplication {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		return "Hello World!";
	}

	public static void main(String[] args) {

		SpringApplication.run(WudyApiApplication.class, args);
	}
}
