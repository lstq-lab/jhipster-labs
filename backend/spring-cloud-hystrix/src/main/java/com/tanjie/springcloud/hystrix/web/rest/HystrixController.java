/**
 * HystrixController.java 2019年6月19日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.springcloud.hystrix.web.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author tanjie
 *
 */
@RestController
public class HystrixController {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "fallback")
	@GetMapping(value = "productOrderlist")
	public String getProductOrderList(@RequestParam Integer number) {
		if (number % 2 == 0) {
			return "success";
		}
		RestTemplate restTemplate = new RestTemplate();
		// throw new RuntimeException("发送异常");
		return restTemplate.postForObject("http://127.0.0.1:9080/product/listForOrder",
				Arrays.asList("157875196366160022"), String.class);
	}

	public String fallback() {
		return "网络开小差了，请稍后重试···";
	}

}
