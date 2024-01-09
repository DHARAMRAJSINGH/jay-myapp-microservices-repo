package com.mycom.vms.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator (RouteLocatorBuilder builder) {

        return builder.routes()
                .route("auth", r -> r.path("/identity-provider/**").uri("lb://AUTH"))
                //.route("employees", r -> r.path("/employees").uri("http://localhost:8081/"))
                .route("employees", r -> r.path("/employees/**").uri("lb://EMPLOYEE"))
                .route("users", r -> r.path("/users/**").uri("lb://USER"))
                .build();
    }
}
