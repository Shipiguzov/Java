package com.ifmo.jjd.lesson17.reflection;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    private String title;
    private LocalDateTime created;

    public Message(String title) {
        this.title = title;
        created = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public int compareTo(Message o) {
        return created.compareTo(o.created);
    }
}
