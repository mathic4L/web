package com.components.security;

/*
не можем просто добавить через http. ..., потому что там еще нет секьюрити контекста
 */

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class MyAuthFilterConfigurer extends AbstractHttpConfigurer<MyAuthFilterConfigurer, HttpSecurity> {

    private AuthenticationEntryPoint authEP = ((request, response, authException) -> {
        response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "hex");
        response.sendError(HttpStatus.UNAUTHORIZED.value());
    });

    public MyAuthFilterConfigurer myAuthFilterConfigurer(AuthenticationEntryPoint authEP) {
        this.authEP = authEP;
        return this;
    }

    @Override
    public void init(HttpSecurity builder) throws Exception {
        /*
        в конфигур регистрируется текущая точка входа как локальная, а тут она же уже как глобальная
         */
        builder.exceptionHandling(c -> c.authenticationEntryPoint(this.authEP)) ;
    }

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        AuthenticationManager authManager = builder.getSharedObject(AuthenticationManager.class);
        // addFilterBefore ~~ addFilterAt
        // + addFilterAfter
        builder.addFilterBefore(new MyAuthFilter(authManager, this.authEP), BasicAuthenticationFilter.class);
    }
}
