package com.mycompany.myapp.config;

import com.google.common.collect.Lists;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

//@Component
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    //存储的的key
    private final static String KEY = "gateway_dynamic_routes";

    @Autowired
    private RedissonClient redissonClient;


    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        List<RouteDefinition> gatewayRouteEntityList=redissonClient.getList(KEY);
        Flux<RouteDefinition> result= Flux.fromIterable(gatewayRouteEntityList);
        return result;
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        redissonClient.getList(KEY).add(route);
        return Mono.empty();
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        List<RouteDefinition> gatewayRouteEntityList=redissonClient.getList(KEY);
        RouteDefinition del = null;
        for (RouteDefinition routeDefinition : gatewayRouteEntityList) {
            if(routeDefinition.getId().equals(routeId)){
                del = routeDefinition;
                break;
            }
        }
        redissonClient.getList(KEY).remove(del);
        return Mono.empty();
    }
}
