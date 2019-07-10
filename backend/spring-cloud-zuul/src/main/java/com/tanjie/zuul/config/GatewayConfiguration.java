/**
 * GatewayConfiguration.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.zuul.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tanjie.zuul.gateway.accesscontrol.AccessControlFilter;
import com.tanjie.zuul.gateway.ratelimiting.RateLimitingFilter;
import com.tanjie.zuul.gateway.responserewriting.SwaggerBasePathRewritingFilter;

import io.github.jhipster.config.JHipsterProperties;

/**
 * @author tanjie
 *
 */
@Configuration
public class GatewayConfiguration {

	@Configuration
	public static class SwaggerBasePathRewritingConfiguration {

		@Bean
		public SwaggerBasePathRewritingFilter swaggerBasePathRewritingFilter() {
			return new SwaggerBasePathRewritingFilter();
		}
	}

	@Configuration
	public static class AccessControlFilterConfiguration {

		@Bean
		public AccessControlFilter accessControlFilter(RouteLocator routeLocator,
				JHipsterProperties jHipsterProperties) {
			return new AccessControlFilter(routeLocator, jHipsterProperties);
		}
	}

	/**
	 * Configures the Zuul filter that limits the number of API calls per user.
	 * <p>
	 * This uses Bucket4J to limit the API calls, see
	 * {@link com.freemud.gateway.gateway.ratelimiting.RateLimitingFilter}.
	 */
	@Configuration
	@ConditionalOnProperty("jhipster.gateway.rate-limiting.enabled")
	public static class RateLimitingConfiguration {

		private final JHipsterProperties jHipsterProperties;

		public RateLimitingConfiguration(JHipsterProperties jHipsterProperties) {
			this.jHipsterProperties = jHipsterProperties;
		}

		@Bean
		public RateLimitingFilter rateLimitingFilter() {
			return new RateLimitingFilter(jHipsterProperties);
		}
	}
}
