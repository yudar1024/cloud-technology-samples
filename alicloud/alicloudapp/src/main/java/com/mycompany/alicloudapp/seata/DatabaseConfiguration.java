/*
 * Copyright (C) 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.alicloudapp.seata;

import java.sql.SQLException;

import com.alibaba.druid.pool.DruidDataSource;


import io.seata.rm.datasource.DataSourceProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author xiaojing
 */
@Configuration
public class DatabaseConfiguration {

	private final ApplicationContext applicationContext;

	public DatabaseConfiguration(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource")
	public DruidDataSource druidDataSource() throws SQLException {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}

	@Bean
	public DataSourceProxy dataSourceProxy(DruidDataSource druid) {
		return new DataSourceProxy(druid);
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSourceProxy dataSourceProxy) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceProxy);

		jdbcTemplate.update("delete from storage_tbl where commodity_code = 'C00321'");
		jdbcTemplate.update(
				"insert into storage_tbl(commodity_code, count) values ('C00321', 100)");

		return jdbcTemplate;

	}

}
