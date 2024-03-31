package com.rozhkov.vacationcalculator.service;

import com.rozhkov.vacationcalculator.model.HolidaysData;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HolidaysService {
    public int getVacationDaysWithHolidaysAndDates(LocalDate startDate, LocalDate endDate) {
        int vacationDaysWithHolidays = 0;
        var holidayDays = HolidaysData.getHolidayDaysList();

        endDate = endDate.plusDays(1);
        while (!startDate.equals(endDate)) {
            var dayOfWeek = startDate.getDayOfWeek().getValue();

            if (dayOfWeek == 6 || dayOfWeek == 7) {
                startDate = startDate.plusDays(1);
                continue;
            }

            if (holidayDays.get(startDate.getMonth())
                    .contains(startDate.getDayOfMonth())) {
                startDate = startDate.plusDays(1);
                continue;
            }

            vacationDaysWithHolidays++;
            startDate = startDate.plusDays(1);
        }
        return vacationDaysWithHolidays;
    }


    public int getVacationDaysWithHolidaysAndStartDay(LocalDate startDate, Integer vacationDays) {
        int vacationDaysWithHolidays = 0;
        var holidayDays = HolidaysData.getHolidayDaysList();

        while (vacationDays != 0) {
            var dayOfWeek = startDate.getDayOfWeek().getValue();

            if (dayOfWeek == 6 || dayOfWeek == 7) {
                vacationDays--;
                startDate = startDate.plusDays(1);
                continue;
            }

            if (holidayDays.get(startDate.getMonth())
                    .contains(startDate.getDayOfMonth())) {
                vacationDays--;
                startDate = startDate.plusDays(1);
                continue;
            }

            vacationDaysWithHolidays++;
            vacationDays--;
            startDate = startDate.plusDays(1);
        }
        return vacationDaysWithHolidays;
    }
}
