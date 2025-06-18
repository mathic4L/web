package org.example.service;

import org.example.entity.Calculation;
import org.example.entity.MyUser;

import java.util.List;

public interface CalculationService {
    public List<Calculation> getAllCalculations(MyUser myUser);
    public Calculation getCalculationById(Long id);
    public Calculation updateCalculation(Calculation calculation);
    public Calculation createCalculation(Calculation calculation);
    public void deleteCalculation(Long id);
}
