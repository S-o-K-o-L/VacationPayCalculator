package com.neoflex.vacationpaycalculator.model;

import lombok.Data;

@Data
public class VacationPayResponse {
    private final double vacationPay;

    public VacationPayResponse(double vacationPay) {
        this.vacationPay = vacationPay;
    }
}
