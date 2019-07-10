/**
 * Application.java 2019年6月19日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.springcloud.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import com.tanjie.springcloud.hystrix.service.HelloService;

/**
 * @author tanjie
 *
 */
@SpringBootApplication
@EnableCircuitBreaker
public class Application implements CommandLineRunner {

	@Autowired
	private HelloService helloService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloService.getHelloContent();
		System.out.println("+++++++++++++++++++++++");
		helloService.getConfigTest();
	}
}
