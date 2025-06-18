package org.example.core.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyCar {

    private String manufacturer;
    private String model;
    private String color;

}
