package com.ifmo.jjd.lesson12.homework2;

public class ExceptionClass {
    private Exception[] array = new Exception[10];
    private int index = 0;

    public void saveException(Exception e) {
        array[index] = e;
        index++;
    }

    public void error() {
        System.out.println(array[0].getMessage());
    }

    public void printException() {
        for (Exception exception : array) {
            if (exception != null) System.out.println(exception.getMessage());
        }
    }
}
