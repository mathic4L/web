package com.security.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyEndPoint {
//    @Bean // с ним не работает вход
    public SecurityFilterChain changePasswordManagement(HttpSecurity http) throws Exception {
        // http // дефолт
        //          .passwordManagement(Customizer.withDefaults())
        http
                .passwordManagement((management) -> management.changePasswordPage("/changePassword"))
        ;

        return http.build();
    }

}
