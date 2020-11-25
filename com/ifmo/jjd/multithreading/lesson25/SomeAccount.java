package com.ifmo.jjd.multithreading.lesson25;

public class SomeAccount {

    private int balance;

    public int getBalance() {
        return balance;
    }

    // поток блокирует монитор объекта, метод которого выполняется (от начала выполнения метода до конца его выполнения)
    public synchronized void upBalance(int count) {
        balance += count;
    }

}
