package com.neoflex.vacationpaycalculator.service;

import com.neoflex.vacationpaycalculator.model.VacationPayRequest;
import com.neoflex.vacationpaycalculator.model.VacationPayResponse;
import com.neoflex.vacationpaycalculator.util.HolidayCalculator;
import org.springframework.stereotype.Service;

@Service
public class VacationCalculatorService {
    private static final int WORKING_DAYS_PER_MONTH = 29; // Среднее количество рабочих дней

    public VacationPayResponse calculateVacationPay(VacationPayRequest request) {
        double averageSalaryPerDay = request.getAverageSalary() / WORKING_DAYS_PER_MONTH;

        int vacationDays = request.getVacationDays();

        if (request.getVacationDates() != null && !request.getVacationDates().isEmpty()) {
            vacationDays = HolidayCalculator.calculateWorkingDays(request.getVacationDates());
        }

        double vacationPay = averageSalaryPerDay * vacationDays;
        return new VacationPayResponse(vacationPay);
    }
}
