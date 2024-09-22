package com.neoflex.vacationpaycalculator.service.strategy;

import com.neoflex.vacationpaycalculator.model.VacationData;

import java.math.BigDecimal;

public interface VacationPayCalculatorStrategy {
    BigDecimal calculate(VacationData vacationData);
}
