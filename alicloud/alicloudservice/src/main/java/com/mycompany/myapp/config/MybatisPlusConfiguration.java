package com.mycompany.myapp.config;

import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class MybatisPlusConfiguration {

//  显示执行的SQL
    @Profile("dev")
    @Bean
    public PerformanceMonitorInterceptor performanceMonitorInterceptor(){
        return new PerformanceMonitorInterceptor();
    }
}
