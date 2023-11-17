package com.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CustomDate {
    LocalDate date;
    String weekday;

    String dayAndMonth;

    //Get the ordinal number to be put after the day of month. Eg: 2nd of November <- "nd" here.
    // % 10 is used to make it work for 21st etc
    private String getOrdinalNumber(int num) {
        switch (num % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    private String makeFirstUpperCase(String str) {
        return str.substring(0, 1) + str.substring(1).toLowerCase();
    }

    CustomDate(LocalDate date) {
        this.date = date;
        DayOfWeek currentDay = date.getDayOfWeek();
        weekday = makeFirstUpperCase(currentDay.name());
        dayAndMonth = String.format("%d%s of %s", date.getDayOfMonth(), getOrdinalNumber(date.getDayOfMonth()), makeFirstUpperCase(date.getMonth().name()));
    }

    boolean isToday() {
        LocalDate currDate =LocalDate.now();
        return currDate.equals(date);
    }
}
