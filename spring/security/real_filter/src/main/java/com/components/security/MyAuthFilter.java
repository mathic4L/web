package com.components.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.filter.OncePerRequestFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyAuthFilter extends OncePerRequestFilter {

    private SecurityContextHolderStrategy secCtxStrategy
            = SecurityContextHolder.getContextHolderStrategy();

    private SecurityContextRepository secCtxRepo
            = new RequestAttributeSecurityContextRepository();

    private AuthenticationManager authManager;
    private AuthenticationEntryPoint authEntryPoint;

    public MyAuthFilter(AuthenticationManager authManager, AuthenticationEntryPoint authEntryPoint) {
        this.authManager = authManager;
        this.authEntryPoint = authEntryPoint;
    }

    private String[] decode(String str) {
        return str.split(":");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authAttempt = request.getHeader("AUTHORIZATION");
        if (authAttempt != null) {
            String[] decoded = decode(authAttempt);
            UsernamePasswordAuthenticationToken upToken =
                    UsernamePasswordAuthenticationToken.unauthenticated(decoded[0], decoded[1]);
            try {
                Authentication auth = this.authManager.authenticate(upToken);
                SecurityContext ctx = secCtxStrategy.createEmptyContext();
                ctx.setAuthentication(auth);
                secCtxStrategy.setContext(ctx);
                secCtxRepo.saveContext(secCtxStrategy.getContext(), request, response);
                filterChain.doFilter(request, response);
            } catch (AuthenticationException e) {
                secCtxStrategy.clearContext();
                authEntryPoint.commence(request, response, e);
                return;
            }


        }

        filterChain.doFilter(request, response);
    }
}
