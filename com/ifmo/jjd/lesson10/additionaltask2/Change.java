package com.ifmo.jjd.lesson10.additionaltask2;

import java.time.LocalTime;

public class Change {
    String name;
    LocalTime begin, end;

    public Change(String name, LocalTime begin, LocalTime end) {
        this.setName(name);
        this.begin = begin;
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 2) throw new IllegalArgumentException("Wrong name of change");
        this.name = name;
    }

    public boolean isThisChange(LocalTime time) {
        if ((time.isAfter(this.begin) || time.equals(this.begin)) && (time.isBefore(this.end) || time.equals(this.end))) return true;
        if (this.begin.isAfter(LocalTime.of(00, 00).minusHours(8)) &&
                (time.isAfter(this.begin) || time.equals(this.begin) || time.isBefore(this.end) || time.equals(this.end))) return true;
        return false;
    }
}
