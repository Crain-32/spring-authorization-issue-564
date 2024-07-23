package dev.crain.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationEntryPoint;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        return http.authorizeExchange(
                        (authorizeRequests) ->
                                authorizeRequests
                                        .pathMatchers("/login").permitAll()
                                        .pathMatchers("/login/**").permitAll()
                                        .pathMatchers("/oauth2/**").permitAll()
                                        .anyExchange().authenticated()
                )
                .exceptionHandling(handler -> handler.authenticationEntryPoint(new RedirectServerAuthenticationEntryPoint("/login")))
                // Disabling this for ease of the example
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors(ServerHttpSecurity.CorsSpec::disable)
                .build();
    }
}