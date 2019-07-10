/**
 * JHipsterLoggingMetricsExportConfiguration.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.spring.project.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanjie
 *
 */
@Configuration
@ConditionalOnProperty("jhipster.metrics.logs.enabled")
public class JHipsterLoggingMetricsExportConfiguration {
	private final Logger log = LoggerFactory.getLogger(JHipsterLoggingMetricsExportConfiguration.class);

	public JHipsterLoggingMetricsExportConfiguration(){
			log.info("JHipsterLoggingMetricsExportConfigurationBean is created!");
	}
}
