/**
 * HelloService.java 2019年6月19日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.springcloud.hystrix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author tanjie
 *
 */

@Service
public class HelloService {
	
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "callFailure")
	public String getHelloContent() {
		return restTemplate.getForObject("http://www.baidu.com/", String.class);
	}

	@HystrixCommand(fallbackMethod = "callFailure")
	public String getConfigTest() {
		return restTemplate.getForObject("http://CONFIG-CLIENT/configtest", String.class);
	}

	public String callFailure(){
        return "service is not available!";
    }
}
