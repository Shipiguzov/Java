package com.ifmo.jjd.patterns.observer;

import java.util.HashSet;

public class StateClass {
    private HashSet<Observer> observers = new HashSet<>();
    private int value;

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    private void lowNotify(int code) {
        observers.forEach(observer -> observer.greenEvent(code));
    }

    private void mediumNotify(int code) {
        observers.forEach(observer -> observer.yellowEvent(code));
    }

    private void highNotify(int code) {
        observers.forEach(observer -> observer.redEvent(code));
    }

    public void changeState(int newValue) {
        this.value = newValue;
        if (newValue == 1) lowNotify(newValue);
        if (newValue == 5) mediumNotify(newValue);
        if (newValue == 10) highNotify(newValue);

    }
}
