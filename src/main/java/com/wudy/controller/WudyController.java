package com.wudy.controller;

import com.wudy.common.WudyRequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wudy.common.WudyResponse;

/**
 * @author : Jaden
 * @since : 01/07/2017
 */

@RestController
public class WudyController {

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public WudyResponse create(@RequestBody WudyRequestParam param) {
		WudyResponse response = new WudyResponse();
		response.setCode(0);
		return response;
	}
}
