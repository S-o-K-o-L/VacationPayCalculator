package com.rozhkov.vacationcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class VacationData {
    private BigDecimal averageSalary;
    private Integer vacationDays;
    private LocalDate startVacation;
    private LocalDate endVacation;
}
