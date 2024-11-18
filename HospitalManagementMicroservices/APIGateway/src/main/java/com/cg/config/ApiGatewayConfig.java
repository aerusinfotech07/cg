package com.cg.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route("doctor-service", r -> r.path("/doctors/**").uri("lb://doctor-service"))
            .route("patient-service", r -> r.path("/patients/**").uri("lb://patient-service"))
            .route("appointment-service", r -> r.path("/appointments/**").uri("lb://appointment-service"))
            .build();
    }
}