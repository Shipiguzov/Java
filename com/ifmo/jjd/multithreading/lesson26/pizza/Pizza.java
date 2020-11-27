package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Pizza {
    public static void main(String[] args) {
        ArrayBlockingQueue<Order> queueFromClients = new ArrayBlockingQueue<>(15);
        LinkedBlockingQueue<Order> queueToChief = new LinkedBlockingQueue<>(5);
        SynchronousQueue<Order> queueFromChief = new SynchronousQueue<>();
        ArrayList<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            threadList.add(new Thread(new Waiter("Waiter #" + i, LocalDate.of(1980 + i, 5 + i, 2 * i + 1), queueFromClients, queueToChief, queueFromChief)));
        }
        for (int i = 0; i < 7; i++) {
            threadList.add(new Thread(new Client("Client #" +i, LocalDate.of(1980 + i, 5 + i, 2 * i + 3), queueFromClients)));
        }
        threadList.add(new Thread(new Chief("Chief", LocalDate.of(1976, Month.AUGUST, 18), queueToChief, queueFromChief)));

        for (Thread thread : threadList) {
            thread.start();
        }

    }
}
