package com.ifmo.jjd.lesson17.reflection;

import java.io.Serializable;

public class TextMessage extends Message implements Serializable {
    private String text;

    public TextMessage(String title) {
        super(title);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void printInfo (String prefix) {
        System.out.println(prefix + " " + getTitle());
    }

}