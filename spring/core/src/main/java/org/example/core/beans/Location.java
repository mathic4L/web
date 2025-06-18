package org.example.core.beans;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

@Getter
@Setter
/*
нельзя смешивать аннотации обычных бинов с аннотациями бинов
создаваемых с использованием configuration properties
 */
@ConfigurationProperties(prefix = "location")
public class Location {



    @PostConstruct
    public void init() {
        System.out.println("Location Size: " + locationSize);
        System.out.println("Location ID: " + locationId);
    }

    private Long locationSize;
    private Long locationId;

    /*
    индицирует какой из конструкторов использовать для инициализации бина configuration properties'ами
    если конструктор всего один, то можно не указывать

    spring приведет разные кодстайлы к camelcase'у для маппинга на имена классовых полей
     */
    @ConstructorBinding
    public Location(Long locationSize, Long locationId) {
        this.locationSize = locationSize;
        this.locationId = locationId;
    }

}
