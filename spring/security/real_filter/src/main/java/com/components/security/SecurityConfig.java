package com.components.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    /*
    последовательность фильтров находится в FilterOrderRegistration
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests((requests) ->
                        requests.anyRequest().authenticated());
        http
                .apply(new MyAuthFilterConfigurer());


//        http
//                .exceptionHandling()
//                .authenticationEntryPoint(((request, response, authException) -> {
//                    response.addHeader("WWW-Authenticate", "Basic realm=\"myrealm\"");
//                    response.sendError(HttpStatus.UNAUTHORIZED.value());
//                }))
        ;

        return http.build();
    }
}
