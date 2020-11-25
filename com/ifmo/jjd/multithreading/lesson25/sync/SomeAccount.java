package com.ifmo.jjd.multithreading.lesson25.sync;

public class SomeAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }
    // поток блокирует монитор объекта метод которого выполняется
    public synchronized void upBalance(int count) {
        balance += count;
    }
}
