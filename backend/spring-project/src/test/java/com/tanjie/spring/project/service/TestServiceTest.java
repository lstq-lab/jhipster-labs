/**
 * TestService.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.spring.project.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author tanjie
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

	@Autowired
	private TestService testService;

	@Test
	public void testTestService() {
		testService.test();
	}
}
