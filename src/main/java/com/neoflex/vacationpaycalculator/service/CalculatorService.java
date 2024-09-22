package com.neoflex.vacationpaycalculator.service;


import com.neoflex.vacationpaycalculator.model.VacationData;
import com.neoflex.vacationpaycalculator.service.strategy.VacationPayCalculatorStrategy;
import com.neoflex.vacationpaycalculator.service.strategy.factory.VacationPayStrategyFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {
    private static final BigDecimal AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH = BigDecimal.valueOf(29.3);
    private static final Integer NUMBER_OF_MONTH = 12;
    private static final Integer SCALE = 2;

    public static BigDecimal calculateSalaryPerDay(BigDecimal averageSalary) {
        return averageSalary
                .divide(BigDecimal.valueOf(NUMBER_OF_MONTH), SCALE, RoundingMode.HALF_UP)
                .divide(AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH, SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal calculate(VacationData vacationData) {
        VacationPayCalculatorStrategy strategy = VacationPayStrategyFactory.getStrategy(vacationData);
        return strategy.calculate(vacationData);
    }
}
