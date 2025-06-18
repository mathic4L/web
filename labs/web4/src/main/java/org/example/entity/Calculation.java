package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity(name = "calculations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Calculation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id"
//            ,referencedColumnName = "id"
    )
    private MyUser myUser;
    private Double x;
    private Double y;
    private Double r;
    private Boolean result;

    public Calculation(Object o, Double x, Double y, Double r) {
        setX(x);
        setY(y);
        setR(r);
        setMyUser(myUser);
    }

    public static void calculateResult(Calculation calculation) {

        final Double x = calculation.getX();
        final Double y = calculation.getY();
        final Double r = calculation.getR();

        if(x >= 0 && y >= 0) {
            calculation.setResult(y <= r - x && x <= r);
        } else if (x >= 0 && y < 0) {
            calculation.setResult(x == 0 && y>=-r);
        } else if (x < 0 && y >= 0) {
            calculation.setResult(x * x + y * y <= r * r);
        } else {
            calculation.setResult(x >= -r/2 && y >= -r);
        }
    }
}
