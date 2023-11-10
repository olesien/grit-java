package com.calendar;

import java.time.LocalDate;

public class Event {
    private LocalDate date;
    private String content;

    Event(LocalDate date, String content) {
        this.date = date;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }
}
