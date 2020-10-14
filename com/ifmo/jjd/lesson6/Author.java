package com.ifmo.jjd.lesson6;

public class Author {
    private String name;
    private String surname;

    // конструктор без параметров нужно описывать всегда, когда нужны конструкторы с параметрами и без них
    public Author(){}

    // конструкторы
    public  Author(String name) {
        setName(name);
        //this.name = name;
    }

    // конструктор
    public Author(String name, String surname) {
        setName(name);
        setSurname(surname);
        //this.name = name;
        //this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() <3)
            throw new IllegalArgumentException("name must be 3 or more letters");
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().length() <3)
            throw new IllegalArgumentException("name must be 3 or more letters");
        this.surname = surname;
    }

    public String getFullName(){
        return name + " " + surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
