package org.example.beans.beans;

import org.example.beans.pojos.Car;
import org.example.beans.pojos.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

// configuration + bean
// единственный вариант, если нудно несколько бинов одного класса


@Configuration
public class Colors {
    // qualifier выводится из имени метода
    @Bean
            // для только этого инстанса Калор дестрой методом будет "disable"
            // имена методов смотрятся внутри класса
            (destroyMethod = "disable")
    public Color colorGreen() {
        return Color.GREEN;
    }

    @Bean
    public Color colorBlue() {
        return Color.BLUE;
    }

    @Bean
    public Color colorRed() {
        return Color.RED;
    }

    // переиспользование бинов
    // a - вызов бин-методов
    @Bean
    public List<Color> colorBrown() {
        return List.of(colorRed(), colorGreen());
    }

    // b
    // использование квалифаера
    @Bean
    @Autowired
    public List<Color> colorPurple(@Qualifier(value = "colorRed") Color red,
                                   @Qualifier(value = "colorBlue") Color blue) {
        return List.of(red, blue);
    }

    // если один бин интерфейса, то можно не использовать квалифаер
    @Bean
    @Autowired
    public Car redCar(Car car) {
        car.setColor(colorRed());
        return car;
    }
}
