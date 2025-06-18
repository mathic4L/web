package org.example;

import org.example.service.CalculationService;

import org.example.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            System.out.println("lab4 started");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}