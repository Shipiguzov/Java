package com.ifmo.jjd.multithreading.lesson25.hwtransaktion;

public class Transaction implements Runnable {
    private Account src; // с какого аккаунта осуществлять перевод
    private Account dst; // на какой аккаунт осуществлять перевод
    private int money; // сколько переводить

    public Transaction(Account src, Account dst, int money) {
        this.src = src;
        this.dst = dst;
        this.money = money;
    }

    @Override
    public void run() {
        // TODO перевод денежных средств со счета src на счет dst
        //  в количестве money
        src.setBalance(src.getBalance() - money);
        dst.setBalance(dst.getBalance() + money);
        System.out.println("Money " + money + " transfered from " + src.getId() + " to " + dst.getId());
        System.out.println("New balance source acount " + src.getBalance() + ". New balance destination account " + dst.getBalance());
    }
}