package eu.stefanangelov.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayServiceApplication.class, args);
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/auth/**", "/users/**")
                .uri("lb://AUTHENTICATION-SERVICE")
                .id("authenticationService"))
            .route(r -> r.path("/rooms/**")
                .uri("lb://ROOM-SERVICE")
                .id("roomService"))
            .build();
    }
}
