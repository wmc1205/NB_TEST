package com.example.config;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableTransactionManagement
public class DataSourceConfig implements WebMvcConfigurer {

	@Autowired 
	private DataSource dataSource;


	/**
	 * Propagation.REQUIRED : 부모 트랜잭션(자신을 호출한 메소드의 Transaction)이 존재한다면 그에 포함되어 동작. 부모 트랜잭션이 존재하지 않을 경우 새로 트랜잭션 생성(default 속성)
	 * Propagation.SUPPORT : 부모 트랜잭션이 존재하면 그에 포함되어 동작. 부모 트랜잭션이 없다면 트랜잭션 없이 동작.
	 * Propagation.MANDATORY : 
	 */
	@Bean
	public PlatformTransactionManager txManager() throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}

}