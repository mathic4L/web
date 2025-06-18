package web.models;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity(name="attempts")
@Data
@NoArgsConstructor

@Named
@SessionScoped
public class Attempt implements Serializable {
    @Getter
    @ToString
    @AllArgsConstructor
    public static class Coordinates {
        private final double x;
        private final double y;
        private final double r;
        private final boolean result;
    }

    public Attempt(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private int id;

    @NotNull
    @Column(nullable = false)
    private double x;

    @NotNull
    @Column(nullable = false)
    private double y;

    @NotNull
    @Column(nullable = false)
    private double r;

    @NotNull
    @Column(nullable = false)
    private boolean result;

    @NotNull
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt = new Date();

    @NotNull
    @Column(nullable = false)
    private Long executionTime;

    public Coordinates getCoordinates() {
        return new Coordinates(x, y, r, result);
    }
}
