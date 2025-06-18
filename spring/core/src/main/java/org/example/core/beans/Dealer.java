package org.example.core.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.core.pojos.MyCar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class Dealer {

    private final List<MyCar> modelsHistory;
    private List<MyCar> availableCars;
    private final Location location;


    /*
    в отличие от ЕЕ спринг бины могут создаваться с использованием конструктора;
    так они создаются по умолчанию
     */
    public Dealer(@Qualifier("focusAnnotation") MyCar focus,
                  @Qualifier("mustangAnnotation") MyCar mustang,
                  Location location
    ) {
        this.location = location;
        modelsHistory = List.of(focus, mustang);
        availableCars = List.of(focus, mustang);
    }
}
