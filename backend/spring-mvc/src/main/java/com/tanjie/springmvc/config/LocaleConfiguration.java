/**
 * LocateConfiguration.java 2019年6月19日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import io.github.jhipster.config.locale.AngularCookieLocaleResolver;

/**
 * @author tanjie
 *
 */
public class LocaleConfiguration implements WebMvcConfigurer {

	@Bean(name = "localeResolver")
	public LocaleResolver localeResolver() {
		AngularCookieLocaleResolver cookieLocaleResolver = new AngularCookieLocaleResolver();
		cookieLocaleResolver.setCookieName("NG_TRANSLATE_LANG_KEY");
		return cookieLocaleResolver;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		registry.addInterceptor(localeChangeInterceptor);
	}

}
