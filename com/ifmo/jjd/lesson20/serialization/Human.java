package com.ifmo.jjd.lesson20.serialization;

import java.io.Serializable;

// Human - Serializable класс, соответственно все его потомки Serializable классы

public class Human implements Serializable {
    protected String name = "Человек";
    protected int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 5) this.age = age;
    }
}
