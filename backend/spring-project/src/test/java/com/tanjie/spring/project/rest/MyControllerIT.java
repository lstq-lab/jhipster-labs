/**
 * MyControllerIT.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.spring.project.rest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @author tanjie
 *
 */
public class MyControllerIT {
	Logger logger = LoggerFactory.getLogger(MyControllerIT.class);

	private MockMvc mvc;

	@Before
	public void setupMockMvc() {
		mvc = MockMvcBuilders.standaloneSetup(new MyController()).build();
	}

	@Test
	public void getName() throws Exception {
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/my/integration/{name}", "lisi");

		// 打印并返回结果
		MvcResult result = mvc.perform(builder)
				// code 是否是200
				.andExpect(MockMvcResultMatchers.status().isOk())
				// 内容是不是 name:lisi
				.andExpect(MockMvcResultMatchers.content().string("name:lisi"))
				// 打印
				.andDo(MockMvcResultHandlers.print())
				// 返回结果
				.andReturn();
		MockHttpServletResponse response = result.getResponse();
		logger.info("响应状态:{},响应内容:{}", response.getStatus(), response.getContentAsString());
	}
}
