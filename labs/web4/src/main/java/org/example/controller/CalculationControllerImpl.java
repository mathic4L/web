package org.example.controller;

import lombok.Data;
import org.example.entity.Calculation;
import org.example.entity.MyUser;
import org.example.service.CalculationService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Data
@RestController
@RequestMapping("/calcs")
public class CalculationControllerImpl implements CalculationController {
    private final CalculationService calculationService;

    @Override
    @GetMapping
    public List<Calculation> getAllCalculations(@AuthenticationPrincipal MyUser myUser) {
        return calculationService.getAllCalculations(myUser);
    }

    @Override
    @PostMapping
    public Calculation createCalculation(@RequestBody Calculation calculation, @AuthenticationPrincipal MyUser myUser) {
        Calculation.calculateResult(calculation);
        calculation.setMyUser(myUser);
        calculationService.createCalculation(calculation);
        return calculation;
    }

    //___________________________________________

    @Override
    @GetMapping("/{id}")
    public Calculation getCalculationById(@PathVariable Long id) {
        return calculationService.getCalculationById(id);
    }

    @Override
    @PutMapping("/{id}")
    public Calculation updateCalculation(@RequestBody Calculation calculation) {
        return calculationService.updateCalculation(calculation);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteCalculationById(@PathVariable Long id) {
        calculationService.deleteCalculation(id);
    }
}
