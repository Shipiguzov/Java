package com.ifmo.jjd.lesson9.playlist;

import java.util.Objects;

public class Song {
    private String name;
    private int duration;
    private Singer singer;

    public Song(String name, int duration, Singer singer) {
        this.name = name;
        this.duration = duration;
        this.singer = singer;
    }

    public void setName(String name) {
        if (name == null || name.trim().length() < 3)
            throw new IllegalArgumentException("Name of song must be not null and more then 3 characters");
        this.name = name;
    }

    public void setDuration(int duration) {
        if (duration <= 0) throw new IllegalArgumentException("duration <= 0");
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public Singer getSinger() {
        return singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return duration == song.duration &&
                name.equals(song.name) &&
                singer.equals(song.singer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration, singer);
    }

    @Override
    protected Song clone() {
        return new Song(
                this.getName(),
                this.getDuration(),
                new Singer(
                        this.getSinger().getName(),
                        this.getSinger().getCountry()
                )
        );
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", singer=" + singer +
                '}';
    }
}
