package com.wudy;

import com.wudy.common.WudyResponse;
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
	public WudyResponse getTempDto(@RequestBody List<String> urlList) {
		return new WudyResponse();
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public WudyResponse getTempDto(@RequestParam String name) {
		return new WudyResponse();
	}

	public static void main(String[] args) {

		System.out.println("Hello World!!!!!");
		SpringApplication.run(WudyApiApplication.class, args);
	}
}
