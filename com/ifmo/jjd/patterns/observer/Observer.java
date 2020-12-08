package com.ifmo.jjd.patterns.observer;

// данный интерфей должны имплементировать все наблюдатели
public interface Observer {
    void greenEvent(int code);
    void yellowEvent(int code);
    void redEvent(int code);
}
