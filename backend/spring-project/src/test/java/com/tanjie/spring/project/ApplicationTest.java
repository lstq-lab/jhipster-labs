/**
 * ApplicationTest.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.spring.project;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanjie
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
	private MockMvc restMockMvc;

	@Before
	public void setup() {
		this.restMockMvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
	}

	@Test
	public void getBackendEndpoint() throws Exception {
		restMockMvc.perform(get("/test")).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN_VALUE))
				.andExpect(content().string("test"));
	}

	@RestController
	public static class TestController {

		@RequestMapping(value = "/test")
		public String test() {
			return "test";
		}
	}
}
