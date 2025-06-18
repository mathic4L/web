package org.example.beans.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Immutable;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
// default name = class name
// для создания бина при наличии нескольких конструкторов будет использован autowire' емый
@Component
@Scope("prototype")
public class Car {
    private String model;
    private Color color;
}
