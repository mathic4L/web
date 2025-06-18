package com.lab;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class CalculationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveCalculation(Calculation calculation) {

        entityManager.getTransaction().begin();
        entityManager.persist(calculation);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}