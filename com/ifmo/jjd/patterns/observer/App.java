package com.ifmo.jjd.patterns.observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Observer firstObserver = new Observer() {
            @Override
            public void greenEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция firstObserver " + code);
            }
        };

        Observer secondObserver = new Observer() {
            @Override
            public void greenEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("Реакция secondObserver " + code);
            }
        };

        System.out.println(firstObserver.getClass());
        System.out.println(secondObserver.getClass());

        System.out.println(Arrays.toString(firstObserver.getClass().getDeclaredConstructors()));

        StateClass stateClass = new StateClass();
        // добавление наблюдателей
        stateClass.addObserver(firstObserver);
        stateClass.addObserver(secondObserver);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            System.out.println("Input a number");
            int code = 0;
            try {
                code = Integer.parseInt(input.readLine());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if (code == 0) break;
            stateClass.changeState(code);
        }
    }
}
