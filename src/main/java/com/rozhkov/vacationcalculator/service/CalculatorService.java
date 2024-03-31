package com.rozhkov.vacationcalculator.service;

import com.rozhkov.vacationcalculator.model.VacationData;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {
    private static final BigDecimal AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH = BigDecimal.valueOf(29.3);
    private static final Integer NUMBER_OF_MONTH = 12;
    private static final Integer SCALE = 2;
    private final HolidaysService holidaysService;

    public CalculatorService(HolidaysService holidaysService) {
        this.holidaysService = holidaysService;
    }

    private BigDecimal calculateSalaryPerDay(@NonNull BigDecimal averageSalary) {
        return averageSalary
                .divide(BigDecimal.valueOf(NUMBER_OF_MONTH), SCALE, RoundingMode.HALF_UP)
                .divide(AVERAGE_NUMBER_OF_DAYS_IN_A_MONTH, SCALE, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateVacationPayWithDates(@NonNull VacationData vacationData) {
        var salaryPerDay = calculateSalaryPerDay(vacationData.getAverageSalary());

        int vacationDaysWithHolidays = holidaysService
                .getVacationDaysWithHolidaysAndDates(vacationData.getStartVacation(), vacationData.getEndVacation());

        return salaryPerDay.multiply(BigDecimal.valueOf(vacationDaysWithHolidays));
    }

    public BigDecimal calculateVacationPayWithStartDay(@NonNull VacationData vacationData) {
        var salaryPerDay = calculateSalaryPerDay(vacationData.getAverageSalary());

        int vacationDaysWithHolidays = holidaysService
                .getVacationDaysWithHolidaysAndStartDay(vacationData.getStartVacation(), vacationData.getVacationDays());

        return salaryPerDay.multiply(BigDecimal.valueOf(vacationDaysWithHolidays));
    }

    public BigDecimal calculateVacationPay(@NonNull VacationData vacationData) {
        var salaryPerDay = calculateSalaryPerDay(vacationData.getAverageSalary());
        return salaryPerDay.multiply(BigDecimal.valueOf(vacationData.getVacationDays()));
    }
}
