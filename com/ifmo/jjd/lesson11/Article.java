package com.ifmo.jjd.lesson11;

import java.time.LocalDate;
import java.util.Objects;

public class Article {
    private final String name;
    private String text;
    private final LocalDate data;
    private Country country;

    public Article(String name) {
        this.name = name;
        this.data = LocalDate.now();
    }

    public Country getCountry() {
        return country;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public LocalDate getData() {
        return data;
    }

    public void setText(String text) {
        if (text == null || text.trim().length() < 3) throw new IllegalArgumentException("Wrong text");
        this.text = text;
    }

    public void setCountry(Country country) {
        Objects.requireNonNull(country, "country");
        this.country = country;
    }
}