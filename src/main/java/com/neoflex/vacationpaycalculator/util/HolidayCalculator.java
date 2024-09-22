package com.neoflex.vacationpaycalculator.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class HolidayCalculator {
    public static int calculateWorkingDays(List<LocalDate> vacationDates) {
        int workingDays = 0;

        for (LocalDate date : vacationDates) {
            if (!isWeekend(date)) {
                workingDays++;
            }
        }

        return workingDays;
    }

    private static boolean isWeekend(LocalDate date) {
        DayOfWeek day = date.getDayOfWeek();
        return day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY;
    }
}
