package com.calendar;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CustomCalendar {
    private Calendar calendar;

    private ArrayList<Event> events = new ArrayList<Event>();

    private LocalDate currentDate;
    private int weekOfYear;
    private int year;
    CustomCalendar() {
        currentDate = LocalDate.now();
        calendar = Calendar.getInstance();

        weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        year = calendar.get(Calendar.YEAR);
        System.out.println("Week number: " + weekOfYear);
    }

    CustomDate getDayOfWeek(int dayIndex) { //dayIndex is between 1 and 7
        DayOfWeek currentDay = currentDate.getDayOfWeek();
        LocalDate newDate = currentDate;
        if (dayIndex > currentDay.getValue()) {
            //We are looking into the future
            System.out.println("Adding time");
            newDate = currentDate.plusDays(dayIndex-currentDay.getValue());
        } else if (dayIndex < currentDay.getValue()) {
            //We are looking into the past
            System.out.println("Removing time");
            newDate = currentDate.minusDays(currentDay.getValue()-dayIndex);
        }
        return new CustomDate(newDate);
    }

    int getWeekOfYear() {
        return weekOfYear;
    }

    int getYear() {
        return year;
    }
    ArrayList<Event> getEvents() {
        return events;
    }

    List<Event> getEventNamesByDate(LocalDate date) {
        return events.stream().filter(e-> e.getDate().equals(date)).collect(Collectors.toList());
    }



    void addEvent(Event newEvent) {
        events.add(newEvent);
    }
    void removeEvent(Event oldEvent) {

        events.remove(oldEvent);
    }

}

