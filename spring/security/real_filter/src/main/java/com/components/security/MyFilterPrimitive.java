package com.components.security;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 */

@Data
public class MyFilterPrimitive extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (request.getHeader("USER_AGENT") == null)
        {
            response.sendError(HttpStatus.FORBIDDEN.value());
            return;
        }
        filterChain.doFilter(request, response);
    }
}
