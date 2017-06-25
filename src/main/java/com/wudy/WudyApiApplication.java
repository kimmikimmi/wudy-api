package com.wudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class WudyApiApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World v1";
	}

	public static void main(String[] args) {

		System.out.println("Hello World!!!!!");
		SpringApplication.run(WudyApiApplication.class, args);
	}
}
