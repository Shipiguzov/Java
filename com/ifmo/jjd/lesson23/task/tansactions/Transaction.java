package com.ifmo.jjd.lesson23.task.tansactions;

public class Transaction {
    private String uuid;
    private long sum;
    private Account account;

    public Transaction(String uuid, long sum, Account account) {
        this.uuid = uuid;
        this.sum = sum;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public String getAccountName() {
        return this.getAccount().getNumber();
    }

    public String getUuid() {
        return uuid;
    }

    public long getSum() {
        return sum;
    }
}