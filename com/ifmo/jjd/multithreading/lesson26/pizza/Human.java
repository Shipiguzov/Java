package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Human {

    String name = "default";
    LocalDate birthDay = LocalDate.now();

    public Human(String name, LocalDate birthDay) {
        this.setName(name);
        this.birthDay = Objects.requireNonNull(birthDay);
    }

    public void setName(String name) {
        if (Objects.isNull(name) || name.length() < 3) throw new IllegalArgumentException("Name must be more 2 chars");
        this.name = name;
    }
}
