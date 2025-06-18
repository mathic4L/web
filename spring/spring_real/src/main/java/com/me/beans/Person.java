package com.me.beans;

import com.me.beans.livingPlace.House;
import com.me.beans.livingPlace.LivingPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Person {
    private String name;
    private LivingPlace livingPlace;

    @PostConstruct
    public void init() {
        System.out.println("init...");
    }
    @PreDestroy
    public void destroy() {
        System.out.println("destroy...");
    }

    public Person() {}

    public Person(String name, LivingPlace livingPlace) {
        this.name = name;
        this.livingPlace = livingPlace;
    }

    public LivingPlace getLivingPlace() {
        return livingPlace;
    }

    public void setLivingPlace(LivingPlace livingPlace) {
        this.livingPlace = livingPlace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    public void stupid(House h) {
        System.out.println(h);
    }

}
