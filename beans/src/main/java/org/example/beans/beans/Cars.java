package org.example.beans.beans;

import org.example.beans.pojos.Car;
import org.example.beans.pojos.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
// only class-level
@PropertySource("classpath:custom_context.properties")
public class Cars {

    @Bean
    public Car newColoredCar(
            // использует проперти сорс уровня класса
            @Autowired Environment environment,
            @Autowired Car car) {
        Color color = environment.getProperty("test.car.color", Color.class);
        car.setColor(color);
        return car;
    }

    @Bean
    public Car newModeledCar(
            // использует проперти сорс = "classpath:application.properties"
            @Value("${main.car.model}") String modelName,
            @Autowired Car car) {
        car.setModel(modelName);
        return car;
    }
}
