/**
 * LiquibaseConfiguration.java 2019年6月21日
 *
 * Copyright (c) 2018, DEEPEXI Inc. All rights reserved.
 * DEEPEXI PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.tanjie.liquibase.config;

import java.util.concurrent.Executor;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;

import io.github.jhipster.config.JHipsterConstants;
import io.github.jhipster.config.liquibase.AsyncSpringLiquibase;
import liquibase.integration.spring.SpringLiquibase;

/**
 * @author tanjie
 *
 */
@Configuration
public class LiquibaseConfiguration {

	private final Logger log = LoggerFactory.getLogger(LiquibaseConfiguration.class);

	private final Environment env;

	private final CacheManager cacheManager;

	public LiquibaseConfiguration(Environment env, CacheManager cacheManager) {
		this.env = env;
		this.cacheManager = cacheManager;
	}

	@Bean
	public SpringLiquibase liquibase(@Qualifier("taskExecutor") Executor executor, DataSource dataSource,
			LiquibaseProperties liquibaseProperties) {

		// Use liquibase.integration.spring.SpringLiquibase if you don't want Liquibase
		// to start asynchronously
		SpringLiquibase liquibase = new AsyncSpringLiquibase(executor, env);
		liquibase.setDataSource(dataSource);
		liquibase.setChangeLog("classpath:config/liquibase/master.xml");
		liquibase.setContexts(liquibaseProperties.getContexts());
		liquibase.setDefaultSchema(liquibaseProperties.getDefaultSchema());
		liquibase.setDropFirst(liquibaseProperties.isDropFirst());
		liquibase.setChangeLogParameters(liquibaseProperties.getParameters());
		if (env.acceptsProfiles(Profiles.of(JHipsterConstants.SPRING_PROFILE_NO_LIQUIBASE))) {
			liquibase.setShouldRun(false);
			System.out.println("激活spring no-liquibase");
		} else {
			liquibase.setShouldRun(liquibaseProperties.isEnabled());
			log.debug("Configuring Liquibase");
			System.out.println("未激活spring no-liquibase");
		}
		return liquibase;
	}
}
