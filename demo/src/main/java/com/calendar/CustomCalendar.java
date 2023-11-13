package com.calendar;
import java.io.*;
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

    private void saveFile() {
        ///ObjectMapper mapper = new ObjectMapper();
        //ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        //writer.writeValue(new File("D:/cp/dataTwo.json"), jsonDataObject);
        //JSONObject obj = new JSONObject();
        try {
            FileOutputStream fos = new FileOutputStream("calendar-data.tmp");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(events);
            oos.close();
            System.out.println("Saved file");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private void readFile() {
        try {
            FileInputStream fis = new FileInputStream("calendar-data.tmp");
            ObjectInputStream ois = new ObjectInputStream(fis);
            events = (ArrayList<Event>) ois.readObject();
            ois.close();
            System.out.println("Read file");
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
    CustomCalendar() {
        currentDate = LocalDate.now();
        calendar = Calendar.getInstance();

        weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        year = calendar.get(Calendar.YEAR);
        readFile();
        //System.out.println("Week number: " + weekOfYear);
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
        saveFile();
    }
    void removeEvent(Event oldEvent) {
        events.remove(oldEvent);
        saveFile();
    }

}

