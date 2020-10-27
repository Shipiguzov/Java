package com.ifmo.jjd.lesson13.generic.types;

public class PairContainer<T, K> {
    private T key;
    private K value;

    public PairContainer(T key, K value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
