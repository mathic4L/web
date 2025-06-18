package org.example.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.context.annotation.ApplicationScope;

@Data
@ApplicationScope
@AllArgsConstructor
public class MyCar {

    private String model;
    private String color;
}
