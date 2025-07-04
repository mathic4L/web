package com.components.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .httpBasic((httpBasic) -> {
                })
                .authorizeHttpRequests(authprize -> {
                    authprize.antMatchers("/myLogin.html").permitAll()
                            .antMatchers("/badAuth.html").permitAll().anyRequest().authenticated();
                })
                .build();
    }
}
