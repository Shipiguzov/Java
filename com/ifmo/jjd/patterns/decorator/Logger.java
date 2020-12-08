package com.ifmo.jjd.patterns.decorator;

public class Logger implements ILogger { // выводит данные в консоль

    @Override
    public void write(String data) {
        System.out.println(data);
    }
}
