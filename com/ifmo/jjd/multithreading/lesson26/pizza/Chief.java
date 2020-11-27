package com.ifmo.jjd.multithreading.lesson26.pizza;

import java.time.LocalDate;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Chief extends Human implements Runnable{

    LinkedBlockingQueue<Order> queueToChief;
    SynchronousQueue<Order> queueFromChief;

    public Chief(String name, LocalDate birthDay, LinkedBlockingQueue<Order> queueToChief, SynchronousQueue<Order> queueFromChief) {
        super(name, birthDay);
        this.queueToChief = queueToChief;
        this.queueFromChief = queueFromChief;
    }

    private void cookDishFromQueue() throws InterruptedException {
        Order order = queueToChief.take();
        System.out.println("Chief took order " + order + " from queue and start cooking");
        Thread.sleep(10000);
        queueFromChief.put(order);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                cookDishFromQueue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
