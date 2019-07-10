/**
 * MyController.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.spring.project.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanjie
 *
 */
@RestController
@RequestMapping(value = "/my")
public class MyController {
	@RequestMapping(value = "/integration/{name}", method = RequestMethod.GET)
	public String integrationTest(@PathVariable String name) {
		return "name:" + name;
	}
}
