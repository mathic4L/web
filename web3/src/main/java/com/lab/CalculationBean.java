package com.lab;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.Data;



@Data
@RequestScoped
@Named
public class CalculationBean {
    @PersistenceContext
    EntityManager entityManager;

    private double x;
    private double y;
    private double r;
    private boolean result;

    public String calculate() {
        Calculation calculation = new Calculation();
        calculation.setX(x);
        calculation.setY(y);
        calculation.setR(r);
        calculation.setRes(x*x + y*y <= r*r);
        entityManager.getTransaction().begin();
        entityManager.persist(calculation);
        entityManager.getTransaction().commit();

        return "results";
    }
}
