package org.example.core.beans;

import org.example.core.pojos.MyCar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyCars {

    @Bean
    @Scope("prototype")
    public MyCar focusAnnotation() {
        return new MyCar("ford", "focus", "blue");
    }

    @Bean
    @Scope("singleton")
    public MyCar mustangAnnotation() {
        return new MyCar("ford", "mustang", "red");
    }

    @Bean
    @Scope("prototype")
    @Profile("test")
    public MyCar gt() {
        return new MyCar("ford", "gt", "blue");
    }
}
