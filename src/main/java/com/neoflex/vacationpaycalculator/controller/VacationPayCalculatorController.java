package com.neoflex.vacationpaycalculator.controller;

import com.neoflex.vacationpaycalculator.model.VacationData;
import com.neoflex.vacationpaycalculator.service.CalculatorService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
public class VacationPayCalculatorController {

    private final CalculatorService calculatorService;

    public VacationPayCalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculate")
    public BigDecimal calculatePay(
            @RequestParam BigDecimal averageSalary,
            @RequestParam Integer vacationDays,
            @RequestParam(value = "startDate", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @RequestParam(value = "endDate", required = false)
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {

        return calculatorService.calculate(
                new VacationData(averageSalary, vacationDays, startDate, endDate));
    }
}

