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

                /*
                локальная точка входа
                * */
                .httpBasic().authenticationEntryPoint(
                        (request, response, authException) ->
                                response.sendRedirect("/badAuth.html")
                ).and()

                /*
                база
                * */
                .authorizeHttpRequests()
                .antMatchers("/myLogin.html").permitAll()
                .antMatchers("/badAuth.html").permitAll()
                .anyRequest().authenticated().and()

                /*
                указание собственной глобальной entry point
                вместо уже сконфигурированных получаемых из basicAuthentication() и loginForm()
                 */
                .exceptionHandling()
                    .authenticationEntryPoint((request, response, authException) ->
                                response.sendRedirect("/myLogin.html"))
//                .and().exceptionHandling()
//                    .defaultAuthenticationEntryPointFor()
                .and().build();
    }
}
