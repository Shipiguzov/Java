package com.ifmo.jjd.exam1;

final public class Human {
    private String surname;
    private String name;
    private int bithYear;

    public Human(String surname, String name, int bithYear) {
        this.setSurname(surname);
        this.setName(name);
        this.setBithYear(bithYear);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("wrong name of human");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() < 3) throw new IllegalArgumentException("wrong surname of human");
        this.surname = surname;
    }

    public void setBithYear(int bithYear) {
        if (bithYear < 1900) throw new IllegalArgumentException("bithYear < 1900");
        this.bithYear = bithYear;
    }

    public static Human createRandomHuman() {
        return new Human(
                Logger.name(Logger.random(1, 8)),
                Logger.surname(Logger.random(1, 8)),
                Logger.random(1970, 2020)
        );
    }

    @Override
    public Human clone() {
        return new Human(
                this.name,
                this.surname,
                this.bithYear
        );
    }

    @Override
    public String toString() {
        return "Human{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
