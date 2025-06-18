package org.example.service;

import lombok.Data;
import org.example.entity.Calculation;
import org.example.entity.MyUser;
import org.example.repository.CalculationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CalculationServiceImpl implements CalculationService {

    final private CalculationRepo calculationRepo;

    @Override
    public List<Calculation> getAllCalculations(MyUser user) {
        return calculationRepo.findAllByMyUser(user);
    }

    @Override
    public Calculation getCalculationById(Long id) {
        return calculationRepo.findById(id).orElse(null);
    }

    @Override
    public Calculation updateCalculation(Calculation calculation) {
        return calculationRepo.save(calculation);
    }

    @Override
    public Calculation createCalculation(Calculation calculation) {
        return calculationRepo.save(calculation);
    }

    @Override
    public void deleteCalculation(Long id) {
        calculationRepo.deleteById(id);
    }
}
