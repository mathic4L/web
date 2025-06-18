package com.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return (args) -> {
            System.out.println("Hello World!");
        };
    }

    // basic auth
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin() // базовая аутентификация
                .and()
                .authorizeHttpRequests().anyRequest().authenticated()
                .and().build();
    }

//    // formLogin (по умолчанию)
//    @Bean
//    public SecurityFilterChain securityFilterChain2(HttpSecurity http) throws Exception {
//        return http
//                .formLogin() // formLogin
//                .and()
//                .authorizeHttpRequests().anyRequest().authenticated()
//                .and().build();
//    }
}
