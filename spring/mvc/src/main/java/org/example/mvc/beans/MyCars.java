package org.example.mvc.beans;

import org.example.mvc.models.MyCar;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyCars {

    public MyCar user1(){
        return new MyCar(1L, "blue", false);
    }

    public MyCar user2(){
        return new MyCar(2L, "red", true);
    }

    public MyCar user3(){
        return new MyCar(3L, "green", false);
    }

}
