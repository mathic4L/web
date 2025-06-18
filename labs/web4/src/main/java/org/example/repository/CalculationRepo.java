package org.example.repository;

import org.example.entity.Calculation;
import org.example.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculationRepo extends JpaRepository<Calculation, Long> {
    List<Calculation> findAllByMyUser(MyUser myUser);
}
