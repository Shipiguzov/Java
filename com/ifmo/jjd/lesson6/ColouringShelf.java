package com.ifmo.jjd.lesson6;

import java.util.Arrays;

public class ColouringShelf {
    private ColouringBook[] colouring;
    private String color = "Красный";

    public ColouringShelf(int count) {
        if (count < 10) throw new IllegalArgumentException("count 10 or more");
        colouring = new ColouringBook[count];
    }

    public ColouringShelf(int count, String color) {
        this(count);// вызов конструктора
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().length() < 2) throw new IllegalArgumentException("color 2 or more letters");
        this.color = color;
    }

    // return в void методах используется !только для того, чтобы прервать работу этого метода
    public void addColouringBook(ColouringBook book) {
        for (int i = 0; i < colouring.length; i++) {
            if (colouring[i] == null) {
                colouring[i] = book;
                return;
            }
        }
    }

    public void addColouringBook(ColouringBook... books) {
        System.out.println(Arrays.toString(books));

    }

    public String getBookInfo() {
        StringBuilder sb = new StringBuilder();
        for (ColouringBook colouringBook : colouring) {
            if (colouringBook != null) {
                sb.append(colouringBook.getTitle()).
                        append(" ").
                        append(colouringBook.getPageCount()).
                        append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "ColouringShelf{" +
                "colouring=" + Arrays.toString(colouring) +
                ", color='" + color + '\'' +
                '}';
    }
}
