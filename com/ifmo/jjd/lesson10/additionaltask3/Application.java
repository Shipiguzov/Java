package com.ifmo.jjd.lesson10.additionaltask3;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Application {
    public static void main(String[] args) {
        LocalDate lastLesson = LocalDate.of(2020, Month.DECEMBER, 21);
        LocalDate todayData;
        int counter = 0;

        todayData = LocalDate.now();
        while (todayData.isBefore(lastLesson) || todayData.isEqual(lastLesson)) {
            if (todayData.getDayOfWeek().toString() == "MONDAY" || todayData.getDayOfWeek().toString() == "WEDNESDAY" || todayData.getDayOfWeek().toString() == "FRIDAY") counter++;
            todayData = todayData.plusDays(1);
        }
        System.out.println("There is " + counter + " lessons left.");
        System.out.println("Diplom will be " + todayData.minusDays(1).plusWeeks(2).toString());
    }
}
