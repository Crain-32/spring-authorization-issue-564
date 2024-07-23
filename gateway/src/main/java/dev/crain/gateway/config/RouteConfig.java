package dev.crain.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("local-resource", r ->
                        r.path("/rest/resource/**", "/rest/resource").filters(GatewayFilterSpec::tokenRelay).uri("lb://resource")
                )
                .route("authentication-flows", r->
                        r.path("/login", "/login/**","/oauth2/**").uri("lb://auth")
                )
                .build();
    }
}
