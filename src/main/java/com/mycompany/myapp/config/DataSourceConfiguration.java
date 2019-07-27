package com.mycompany.myapp.config;

import com.zaxxer.hikari.HikariDataSource;
import io.github.jhipster.config.JHipsterConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@Profile(JHipsterConstants.SPRING_PROFILE_PRODUCTION)
public class DataSourceConfiguration {


//  配置DataSourceProperties解决 Caused by: java.lang.IllegalArgumentException: dataSource or dataSourceClassName or jdbcUrl is required.问题
//  解决方案二 将spring.datasource.primary.url 改为 spring.datasource.primary.jdbc-url 添加 spring.datasource.primary.name 属性， 同时添加spring.datasource.primary.driver-class-name 属性
    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties firstDataSourceProperties() {
        return new DataSourceProperties();
    }


    @Bean(name = "primaryDataSource")
//    @Qualifier("primaryDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource primaryDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.secondary")
    public DataSourceProperties secondDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "secondaryDataSource")
//    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix="spring.datasource.secondary")
    @Profile(JHipsterConstants.SPRING_PROFILE_PRODUCTION)
    public DataSource secondaryDataSource() {
        return secondDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
