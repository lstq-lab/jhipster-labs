/**
 * RateLimitingFilter.java 2019年6月18日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.zuul.gateway.ratelimiting;

import java.time.Duration;
import java.util.function.Supplier;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.configuration.CompleteConfiguration;
import javax.cache.configuration.MutableConfiguration;
import javax.cache.spi.CachingProvider;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.tanjie.zuul.security.SecurityUtils;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.grid.GridBucketState;
import io.github.bucket4j.grid.ProxyManager;
import io.github.bucket4j.grid.jcache.JCache;
import io.github.jhipster.config.JHipsterProperties;

/**
 * Zuul filter for limiting the number of HTTP calls per client.
 *
 * See the Bucket4j documentation at
 * https://github.com/vladimir-bukhtoyarov/bucket4j
 * https://github.com/vladimir-bukhtoyarov/bucket4j/blob/master/doc-pages/jcache-usage
 * .md#example-1---limiting-access-to-http-server-by-ip-address
 */
public class RateLimitingFilter extends ZuulFilter {
	private final Logger log = LoggerFactory.getLogger(RateLimitingFilter.class);
	public final static String GATEWAY_RATE_LIMITING_CACHE_NAME = "gateway-rate-limiting";
	private final JHipsterProperties jHipsterProperties;
	private javax.cache.Cache<String, GridBucketState> cache;
	private ProxyManager<String> buckets;

	public RateLimitingFilter(JHipsterProperties jHipsterProperties) {
		this.jHipsterProperties = jHipsterProperties;

		CachingProvider cachingProvider = Caching.getCachingProvider();
		CacheManager cacheManager = cachingProvider.getCacheManager();
		CompleteConfiguration<String, GridBucketState> config = new MutableConfiguration<String, GridBucketState>()
				.setTypes(String.class, GridBucketState.class);

		this.cache = cacheManager.createCache(GATEWAY_RATE_LIMITING_CACHE_NAME, config);
		this.buckets = Bucket4j.extension(JCache.class).proxyManagerForCache(cache);
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		String bucketId = getId(RequestContext.getCurrentContext().getRequest());
		Bucket bucket = buckets.getProxy(bucketId, getConfigSupplier());
		if (bucket.tryConsume(1)) {
			// the limit is not exceeded
			log.debug("API rate limit OK for {}", bucketId);
		} else {
			// limit is exceeded
			log.info("API rate limit exceeded for {}", bucketId);
			apiLimitExceeded();
		}
		return null;
	}

	/**
	 * The ID that will identify the limit: the user login or the user IP address.
	 */
	private String getId(HttpServletRequest httpServletRequest) {
		return SecurityUtils.getCurrentUserLogin().orElse(httpServletRequest.getRemoteAddr());
	}

	private Supplier<BucketConfiguration> getConfigSupplier() {
		return () -> {
			JHipsterProperties.Gateway.RateLimiting rateLimitingProperties = jHipsterProperties.getGateway()
					.getRateLimiting();

			return Bucket4j.configurationBuilder().addLimit(Bandwidth.simple(rateLimitingProperties.getLimit(),
					Duration.ofSeconds(rateLimitingProperties.getDurationInSeconds()))).build();
		};
	}

	/**
	 * Create a Zuul response error when the API limit is exceeded.
	 */
	private void apiLimitExceeded() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
		if (ctx.getResponseBody() == null) {
			ctx.setResponseBody("API rate limit exceeded");
			ctx.setSendZuulResponse(false);
		}
	}

}
