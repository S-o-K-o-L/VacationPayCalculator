package com.neoflex.vacationpaycalculator.service.strategy.impl;

import com.neoflex.vacationpaycalculator.model.VacationData;
import com.neoflex.vacationpaycalculator.service.CalculatorService;
import com.neoflex.vacationpaycalculator.service.HolidaysService;
import com.neoflex.vacationpaycalculator.service.strategy.VacationPayCalculatorStrategy;

import java.math.BigDecimal;

public class VacationPayWithDatesCalculator implements VacationPayCalculatorStrategy {
    @Override
    public BigDecimal calculate(VacationData vacationData) {
        var salaryPerDay = CalculatorService
                .calculateSalaryPerDay(vacationData.getAverageSalary());
        if (vacationData.getStartVacation().isAfter(vacationData.getEndVacation())) {
            return BigDecimal.ZERO;
        }
        int vacationDaysWithHolidays = HolidaysService
                .getVacationDaysWithHolidaysAndDates(
                        vacationData.getStartVacation(), vacationData.getEndVacation());
        return salaryPerDay
                .multiply(BigDecimal.valueOf(vacationDaysWithHolidays));
    }
}
