package com.ifmo.jjd.multithreading.lesson25.hwtransaktion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TransactionApp {
    public static void main(String[] args) {

        Bank bank = new Bank();
        bank.makeAccountList();
        int srcID = 0;
        int dstID = 0;
        int money = 0;
        while (true) {
            BufferedReader inputFromConsole = new BufferedReader(new InputStreamReader(System.in));
            try {
                System.out.println("Transaction from: ");
                srcID = Integer.parseInt(inputFromConsole.readLine());
                System.out.println("Transaction to: ");
                dstID = Integer.parseInt(inputFromConsole.readLine());
                System.out.println("Money: ");
                money = Integer.parseInt(inputFromConsole.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            bank.transferMoney(bank.getAccount(srcID), bank.getAccount(dstID), money);
        }
    }
}
