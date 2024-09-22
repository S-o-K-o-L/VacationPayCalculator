package com.neoflex.vacationpaycalculator.controller;

import com.neoflex.vacationpaycalculator.model.VacationPayRequest;
import com.neoflex.vacationpaycalculator.model.VacationPayResponse;
import com.neoflex.vacationpaycalculator.service.VacationCalculatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
public class VacationPayController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationPayController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }

    @GetMapping
    public VacationPayResponse calculateVacationPay(@RequestBody VacationPayRequest request) {
        return vacationCalculatorService.calculateVacationPay(request);
    }
}

