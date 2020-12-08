package com.ifmo.jjd.multithreading.lesson25.hwtransaktion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TransactionApp {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.makeAccountList();
        List<Integer> accountIDs = new ArrayList<>();
        Random random = new Random();
        for (Account account : bank.accounts) {
            accountIDs.add(account.getId());
        }
        while (true) {
            //BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));
            synchronized (bank.accounts) {
                bank.transferMoney(bank.getAccount(accountIDs.get(random.nextInt(accountIDs.size()))),
                        bank.getAccount(accountIDs.get(random.nextInt(accountIDs.size()))),
                        random.nextInt(1000));
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
