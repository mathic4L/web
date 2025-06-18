package org.example.core;

import org.example.core.pojos.MyCar;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;



import java.util.Arrays;


public class ManualConfigApplication {

    public static void main(String[] args) {
        ApplicationContext[] applicationContexts = new ApplicationContext[]{
                ApplicationConfigurer.annotations(),
                ApplicationConfigurer.xml(),
                ApplicationConfigurer.generic()
        };

        Arrays.stream(applicationContexts).forEach(ctx -> {
            // Принудительное обновление контекста
            if (ctx instanceof ConfigurableApplicationContext) {
                ((ConfigurableApplicationContext) ctx).refresh();
            }
            ctx.getBeansOfType(MyCar.class).forEach((key, value) ->
                    System.out.println(value));
        });
        ApplicationContext ctx = ApplicationConfigurer.generic();
        ctx.getBeansOfType(MyCar.class).forEach((key, value) ->
                System.out.println(value));
    }
}


/*
GenericApplicationContext —
программная конфигурация бинов;
● ClassPathXmlApplicationContext —
конфигурация бинов при помощи xml;
● AnnotationConfigApplicationContext —
конфигурация бинов при помощи аннотаций;
 */


class ApplicationConfigurer {

    /*
    позволяет комбинировать другие способы инициализации

    внутри ApplicationContext встрены различные хендлеры для обработки аннотаций/хмл
     */
    public static ApplicationContext generic(){
        GenericApplicationContext ctx = new GenericApplicationContext();
        ctx.registerBean("focusGeneric",MyCar.class, "ford", "focus", "blue");
        ctx.registerBean("mustangGeneric", MyCar.class, "ford", "mustang", "red");
        return ctx;
    }

    public static ApplicationContext xml(){
        AbstractXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx;
    }

    public static ApplicationContext annotations(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.scan("org.example.core.beans");
        return ctx;
    }
}


