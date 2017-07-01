package com.wudy.controller;

import com.wudy.TempDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */


@RestController
public class WudyController {

	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public TempDto getTempDto(@RequestParam String name) {
		TempDto t= new TempDto();
		t.setA("b");
		return t;
	}
}
