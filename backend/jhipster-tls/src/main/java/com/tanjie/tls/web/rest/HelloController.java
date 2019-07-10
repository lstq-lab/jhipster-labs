/**
 * HelloController.java 2019年6月21日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.tls.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tanjie
 *
 */
@RestController
@RequestMapping("api/v1")
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        return "hello,world";
    }
}
