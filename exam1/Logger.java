package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Logger {

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.of(2020, Month.OCTOBER, 17, 14, 00, 00);
    }

    public static int random(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1) + minRange);
    }

    public static String abonimentType() {
        int temp = random(1,3);
        switch (temp) {
            case 1: return "oneday";
            case 2: return "day";
            case 3: return "full";
        }
        return null;
    }

    public static LocalDate randomDate(int minYear, int maxYear, int minMonth, int maxMonth, int minDay, int maxDay) {
        return LocalDate.of(
                random(minYear, maxYear),
                random(minMonth, maxMonth),
                random(minDay, maxDay)
        );
    }

    public static String name(int number) {
        switch (number) {
            case 1:
                return "Александр";
            case 2:
                return "Василий";
            case 3:
                return "Алексей";
            case 4:
                return "Вальдемар";
            case 5:
                return "Ярослав";
            case 6:
                return "Роман";
            case 7:
                return "Лев";
            case 8:
                return "Никита";
        }
        throw new IllegalArgumentException("number in letter out of range");
    }

    public static String surname(int number) {
        switch (number) {
            case 1:
                return "Александров";
            case 2:
                return "Васильев";
            case 3:
                return "Петров";
            case 4:
                return "Сидоров";
            case 5:
                return "Иванов";
            case 6:
                return "Романов";
            case 7:
                return "Костльев";
            case 8:
                return "Никитин";
        }
        throw new IllegalArgumentException("number in letter out of range");
    }
}
