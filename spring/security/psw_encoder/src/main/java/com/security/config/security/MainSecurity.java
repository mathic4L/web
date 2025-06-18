package com.security.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Security;

@Configuration
public class MainSecurity {
//
//    This configuration is not complex or extensive, but it does a lot:
//    Require authentication to every URL in your application
//    Generate a login form for you
//    Let the user with a Username of user and a Password of password authenticate with form based authentication
//    Let the user logout
//    CSRF attack prevention
//    Session Fixation protection
//    Security Header integration:
//    HTTP Strict Transport Security for secure requests
//    X-Content-Type-Options integration
//    Cache Control (which you can override later in your application to allow caching of your static resources)
//    X-XSS-Protection integration
//    X-Frame-Options integration to help prevent Clickjacking
//    Integration with the following Servlet API methods:
//    HttpServletRequest#getRemoteUser()
//    HttpServletRequest#getUserPrincipal()
//    HttpServletRequest#isUserInRole(java.lang.String)
//    HttpServletRequest#login(java.lang.String, java.lang.String)
//    HttpServletRequest#logout()

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//        userBuilder.username("admin").password("admin").roles("ADMIN");
//        manager.createUser(userBuilder.build());
//        userBuilder.username("user").password("user").roles("USER");
//        manager.createUser(userBuilder.build());
//        return manager;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        return http.build();
    }


}
