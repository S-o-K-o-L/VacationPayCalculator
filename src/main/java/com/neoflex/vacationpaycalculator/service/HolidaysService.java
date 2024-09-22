package com.neoflex.vacationpaycalculator.service;

import com.neoflex.vacationpaycalculator.model.HolidaysData;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class HolidaysService {
    public static int getVacationDaysWithHolidaysAndDates(LocalDate startDate, LocalDate endDate) {
        int vacationDaysWithHolidays = 0;
        var holidayDays = HolidaysData.getHolidayDaysList();

        endDate = endDate.plusDays(1);
        while (!startDate.equals(endDate)) {
            var dayOfWeek = startDate.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.SATURDAY)
                    || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
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


    public static int getVacationDaysWithHolidaysAndStartDay(LocalDate startDate, Integer vacationDays) {
        int vacationDaysWithHolidays = 0;
        var holidayDays = HolidaysData.getHolidayDaysList();

        while (vacationDays != 0) {
            var dayOfWeek = startDate.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.SATURDAY)
                    || dayOfWeek.equals(DayOfWeek.SUNDAY)) {
                vacationDays--;
                startDate = startDate.plusDays(1);
                continue;
            }

            if (holidayDays.getOrDefault(startDate.getMonth(), List.of())
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
