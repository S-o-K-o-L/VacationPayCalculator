package com.neoflex.vacationpaycalculator.service.strategy.impl;

import com.neoflex.vacationpaycalculator.model.VacationData;
import com.neoflex.vacationpaycalculator.service.CalculatorService;
import com.neoflex.vacationpaycalculator.service.strategy.VacationPayCalculatorStrategy;

import java.math.BigDecimal;

public class DefaultVacationPayCalculator implements VacationPayCalculatorStrategy {
    @Override
    public BigDecimal calculate(VacationData vacationData) {
        var salaryPerDay = CalculatorService
                .calculateSalaryPerDay(vacationData.getAverageSalary());
        return salaryPerDay
                .multiply(BigDecimal.valueOf(vacationData.getVacationDays()));
    }
}
