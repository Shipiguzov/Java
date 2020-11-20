package com.ifmo.jjd.lesson23.task.pupils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Pupil {

    enum Gender {
        MALE, FEMALE
    }

    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;


    public Pupil(int number, String name, Gender gender, LocalDate birth) {
        this.number = number;
        this.setName(name);
        this.setGender(gender);
        this.birth = birth;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Objects.isNull(name) || name.length() < 3) throw new IllegalArgumentException("Length of name < 3");
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        if ((gender != Gender.MALE) && gender != Gender.FEMALE) throw new IllegalArgumentException("Wrong gender");
        this.gender = gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public static Pupil getInstance() {
        String[] maleNames = {"Ivan", "Alex", "Pavel"};
        String[] femaleNames = {"Ann", "Kristina", "Evgenia"};
        boolean gender = (Math.random() < 0.5);
        if (gender) return new Pupil(
                (int) (Math.random() * 2),
                femaleNames[(int) (Math.random() * (femaleNames.length - 1))],
                Gender.FEMALE,
                LocalDate.of((int) (Math.random() * 20) + 1980, (int) (Math.random() * 11) + 1, (int) (Math.random() * 29) + 1)
        );
        else return new Pupil(
                (int) (Math.random() * 10),
                maleNames[(int) (Math.random() * (femaleNames.length - 1))],
                Gender.MALE,
                LocalDate.of((int) (Math.random() * 20) + 1980, (int) (Math.random() * 11 + 1), (int) (Math.random() * 29) + 1)
        );
    }

    public int getAge() {
        return (int)ChronoUnit.YEARS.between(getBirth(), LocalDate.now());
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", Age=" + getAge() +
                '}';
    }
}