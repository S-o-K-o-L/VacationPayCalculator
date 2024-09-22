package com.neoflex.vacationpaycalculator.service.strategy.factory;

import com.neoflex.vacationpaycalculator.model.VacationData;
import com.neoflex.vacationpaycalculator.service.strategy.VacationPayCalculatorStrategy;
import com.neoflex.vacationpaycalculator.service.strategy.impl.DefaultVacationPayCalculator;
import com.neoflex.vacationpaycalculator.service.strategy.impl.VacationPayWithDatesCalculator;
import com.neoflex.vacationpaycalculator.service.strategy.impl.VacationPayWithStartDateCalculator;
import org.springframework.stereotype.Service;


@Service
public class VacationPayStrategyFactory {
    public static VacationPayCalculatorStrategy getStrategy(VacationData vacationData) {
        if (vacationData.getStartVacation() != null && vacationData.getEndVacation() != null) {
            return new VacationPayWithDatesCalculator();
        } else if (vacationData.getStartVacation() != null) {
            return new VacationPayWithStartDateCalculator();
        } else {
            return new DefaultVacationPayCalculator();
        }
    }
}
