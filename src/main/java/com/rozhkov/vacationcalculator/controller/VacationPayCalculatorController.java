package com.rozhkov.vacationcalculator.controller;

import com.rozhkov.vacationcalculator.model.VacationData;
import com.rozhkov.vacationcalculator.service.CalculatorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;

@RestController
public class VacationPayCalculatorController {
    private final CalculatorService calculatorService;

    public VacationPayCalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    public BigDecimal calculatePay(@RequestParam(value = "averageSalary") String averageSalary,
                                   @RequestParam(value = "vacationDays") Integer vacationDays,
                                   @RequestParam(value = "startDate", required = false)
                                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                   @RequestParam(value = "endDate", required = false)
                                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) throws DateTimeException {
        VacationData vacationData =
                new VacationData(
                        new BigDecimal(averageSalary),
                        vacationDays,
                        startDate,
                        endDate);
        BigDecimal vacationPay;

        if (startDate != null && endDate != null) {
            if (startDate.isAfter(endDate)) {
                throw new DateTimeException("StartDate > EndDate");
            }
            vacationPay = calculatorService
                    .calculateVacationPayWithDates(vacationData);
        } else if (startDate != null) {
            vacationPay = calculatorService
                    .calculateVacationPayWithStartDay(vacationData);
        } else {
            vacationPay = calculatorService
                    .calculateVacationPay(vacationData);
        }
        return vacationPay;
    }
}
