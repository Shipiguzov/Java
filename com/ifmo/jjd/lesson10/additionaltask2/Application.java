package com.ifmo.jjd.lesson10.additionaltask2;

import java.time.LocalTime;

public class Application {
    public static void main(String[] args) {
        Change morinigChange = new Change("morning", LocalTime.of(7,00), LocalTime.of(14, 59));
        Change dayChange = new Change("day", LocalTime.of( 15,00), LocalTime.of(22, 59));
        Change nightChange = new Change("night", LocalTime.of(23,00), LocalTime.of(6, 59));

        LocalTime time = LocalTime.of(23, 00);
        if (morinigChange.isThisChange(time)) System.out.println("Morning Change");
        if (dayChange.isThisChange(time)) System.out.println("Day Change");
        if (nightChange.isThisChange(time)) System.out.println("Night Change");
    }
}
