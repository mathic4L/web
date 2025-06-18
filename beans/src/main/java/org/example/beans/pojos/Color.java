package org.example.beans.pojos;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Getter
@AllArgsConstructor
public enum Color {
    RED(true),
    GREEN(true),
    BLUE(true);

    @Setter
    private boolean availability;

    // для всех бинов метод становится постконстрактом
    @PostConstruct
    public void enable() {
        setAvailability(true);
        System.out.println("Color " + name() + " enabled");
    }
    public void disable() {
        setAvailability(false);
        System.out.println("Color " + name() + " disabled");
    }

}
