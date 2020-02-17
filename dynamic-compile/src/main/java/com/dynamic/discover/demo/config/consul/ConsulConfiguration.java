package com.dynamic.discover.demo.config.consul;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("consul")
@Configuration
@EnableDiscoveryClient
public class ConsulConfiguration {
}
