package com.mycompany.alicloudapp.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages ={"com.mycompany.alicloudapp.feign"} )
public class FeignClientConfiguration {
}
