package com.ifmo.jjd.multithreading.lesson25.hwtransaktion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Bank {

    ArrayList<Account> accounts = new ArrayList<>();

    public Account getAccount(int accountID) {
        for (Account account : accounts) {
            if (account.getId() == accountID) return account;
        }
        return null;
    }

    public void transferMoney(Account src, Account dst, int money) {
        Thread transaction = new Thread(new Transaction(src, dst, money));
        transaction.start();
    }

    public void makeAccountList() {
        ArrayList<Integer> idList = new ArrayList<>();
        int maxSizeList = 10;

        while (idList.size() < maxSizeList) {
            int temp = idList.size();
            for (int i = 0; i < maxSizeList - temp; i++) {
                idList.add((int) (Math.random() * 100));
            }
            idList = idList.stream()
                    .distinct()
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        for (int i = 0; i < maxSizeList; i++) {
            this.accounts.add(new Account(idList.get(i), (int) (Math.random() * 10000)));
        }
        System.out.println(accounts);
    }
}