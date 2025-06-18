package org.example.controller;

import org.example.entity.Calculation;
import org.example.entity.MyUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CalculationController {
    List<Calculation> getAllCalculations(MyUser myUser);
    Calculation getCalculationById(Long id);
    Calculation updateCalculation(Calculation calculation);
    Calculation createCalculation(Calculation calculation, MyUser myUser);
    void deleteCalculationById(Long id);
}
