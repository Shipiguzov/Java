package com.ifmo.jjd.patterns.chain;

public interface IHandler {

    IHandler setNext(IHandler handler);

    void handleRequest(Object someData, Priority priority);
}
