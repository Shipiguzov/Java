package com.ifmo.jjd.lesson17.annotations;

@Config(description = "Описание класса", version = 2)
public class SomeClass {

    @Required // NotNull Min(2) Max(100)
    private String stringData;

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "stringData='" + stringData + '\'' +
                '}';
    }
}
