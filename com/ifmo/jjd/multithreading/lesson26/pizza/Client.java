package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.time.LocalDate;
import java.util.concurrent.ArrayBlockingQueue;

public class Client extends Human implements Runnable{

    ArrayBlockingQueue<Order> queueFromClients;

    public Client(String name, LocalDate birthDay, ArrayBlockingQueue queue) {
        super(name, birthDay);
        this.queueFromClients = queue;
    }

    private void putOrderToClientQueue() throws InterruptedException {
        Order order = Order.generateNewDish();
        Thread.sleep(7000);
        queueFromClients.put(order);
        System.out.println("Client put order " + order + " in client's queue for waiters");
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                putOrderToClientQueue();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

        }
    }
}
