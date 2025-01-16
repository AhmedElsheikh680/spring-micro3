package com.spring.gateway.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p.path("/get")
                        .filters(f -> f.addRequestHeader("content-type", "application/json")
                                .addRequestParameter("key-name", "Ahmed Elsheikh"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/football/**")
//                        .uri("lb://football/")) // microservice name
                        .uri("http://localhost:8070"))
                .route(p -> p.path("/team/**")
//                        .uri("lb://team/")) // microservice name
                        .uri("http://localhost:9999"))

                .route(p -> p.path("/team-players/**")
//                        .filters(f -> f.rewritePath("/team/", "/team-players/"))
                        .filters(f -> f.rewritePath("/team-players/(?<segment>.*)", "/team/${segment}"))
//                        .uri("lb://team/"))
                        .uri("http://localhost:9999"))
                .build();
    }

//    @Bean
//    public RouteLocator getRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
//        return routeLocatorBuilder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f -> f.addRequestHeader("sp-header", "the header"))
//                        .uri("http://httpbin.org:80"))
//                .build();
//    }
}
