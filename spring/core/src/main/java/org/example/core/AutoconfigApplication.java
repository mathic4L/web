package org.example.core;

import org.example.core.beans.Dealer;
import org.example.core.beans.Location;
import org.example.core.pojos.MyCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/*
= @ComponentScan + refresh()
 */
@EnableConfigurationProperties
        (Location.class)
@ConfigurationPropertiesScan(basePackages = "org.example.core")
@SpringBootApplication
public class AutoconfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoconfigApplication.class, args);
    }

    @Bean
    @Autowired
    public CommandLineRunner commandLineRunner(ConfigurableApplicationContext ctx) {
        return args -> {
            System.out.println(Arrays.toString(ctx.getBeanNamesForType(MyCar.class)));
//            System.out.println(ctx.getBean("location"));
            System.out.println(Arrays.toString(ctx.getBeanNamesForType(Dealer.class)));
        };
    }
}