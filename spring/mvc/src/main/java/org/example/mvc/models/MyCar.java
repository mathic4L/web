package org.example.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Scope;

@Data
@Scope("singleton")
@AllArgsConstructor
public class MyCar {

    private Long userId;
    private String color;
    private boolean isDirty;

}
