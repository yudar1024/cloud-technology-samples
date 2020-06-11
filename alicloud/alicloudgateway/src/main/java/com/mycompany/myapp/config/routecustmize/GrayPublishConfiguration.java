package com.mycompany.myapp.config.routecustmize;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.gateway.config.LoadBalancerProperties;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrayPublishConfiguration {
    @Bean
    @ConditionalOnMissingBean({GrayPublishReactiveLoadBalancerClientFilter.class})
    public GrayPublishReactiveLoadBalancerClientFilter grayPublishReactiveLoadBalancerClientFilter(LoadBalancerClientFactory clientFactory, LoadBalancerProperties properties) {
        return new GrayPublishReactiveLoadBalancerClientFilter(clientFactory, properties);
    }
}
