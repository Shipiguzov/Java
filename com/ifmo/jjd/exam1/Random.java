package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Random {
    public final static String POOL = "pool";
    public final static String GYM = "gym";
    public final static String GROUP = "group";
    public final static String ONCE = "once";
    public final static String DAY = "day";
    public final static String FULL = "full";

    public static LocalDateTime getCurrentDateTime() {
        return LocalDateTime.of(2020, Month.OCTOBER, 17, 14, 00, 00);
    }

    public static int random(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1) + minRange);
    }

    public static String abonimentType() {
        int temp = random(0, 2);
        String[] abonnementType = {ONCE, DAY, FULL};
        return abonnementType[temp];
    }

    public static LocalDate randomDate(int minYear, int maxYear, int minMonth, int maxMonth, int minDay, int maxDay) {
        return LocalDate.of(
                random(minYear, maxYear),
                random(minMonth, maxMonth),
                random(minDay, maxDay)
        );
    }

    public static String name(int number) {
        String[] names = {
                "Александр",
                "Василий",
                "Алексей",
                "Вальдемар",
                "Ярослав",
                "Роман",
                "Лев",
                "Никита"
        };
        if (number > names.length - 1) throw new IllegalArgumentException("number in name out of range");
        return names[number];
    }

    public static String surname(int number) {
        String[] surname = {
                "Александров",
                "Васильев",
                "Петров",
                "Сидоров",
                "Иванов",
                "Романов",
                "Костльев",
                "Никитин"
        };
        if (number > surname.length - 1) throw new IllegalArgumentException("number in surname out of range");
        return surname[number];
    }
}
