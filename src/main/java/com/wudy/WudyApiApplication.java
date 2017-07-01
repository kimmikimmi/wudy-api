package com.wudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class WudyApiApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World v1";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public TempDto getTempDto(@RequestBody List<String> urlList) {
		return new TempDto();
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public TempDto getTempDto(@RequestParam String name) {
		return new TempDto();
	}

	public static void main(String[] args) {

		System.out.println("Hello World!!!!!");
		SpringApplication.run(WudyApiApplication.class, args);
	}
}
