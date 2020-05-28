package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.HomeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterResource {

    @Bean
    public RouterFunction<ServerResponse> routeHelloWorld(HomeHandler homeHandler) {

        return RouterFunctions.route(RequestPredicates.GET("/").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), homeHandler::helloWorld);
    }

    @Bean
    public RouterFunction<ServerResponse> routeTest(HomeHandler homeHandler) {

        return RouterFunctions.route(RequestPredicates.GET("/test").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), homeHandler::helloWorld);
    }
}
