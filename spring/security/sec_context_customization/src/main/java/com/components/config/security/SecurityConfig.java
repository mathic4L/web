package com.components.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /*
    httpBasic - добавление HttpBasicConfigurer' в контекст безопасности
    это такой же configurer, как и MySecConfigurer
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().realmName("my-realm");
        http
                .apply(new MySecConfigurer()).realmName("my-realm");

        return http.build();
    }
}
