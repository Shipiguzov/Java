package com.ifmo.jjd.patterns.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance; // обязательное

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() { // обязательный, для защиты от многопоточности - synchronized
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;

    }
}
