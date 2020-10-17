package com.ifmo.jjd.lesson9.playlist;

import java.util.Objects;

public final class Singer {
    private String name;
    private String country;

    public Singer(String name, String country) {
        this.setName(name);
        this.setCountry(country);
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3) throw new IllegalArgumentException("Name of singer must be not null and more then 3 characters");
        this.name = name;
    }

    public void setCountry(String country) {
        if (country == null || country.trim().length() < 3) throw new IllegalArgumentException("Country must be not null and more then 3 characters");
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Singer singer = (Singer) o;
        return name.equals(singer.name) &&
                country.equals(singer.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country);
    }
}
