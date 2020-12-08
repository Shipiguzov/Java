package com.ifmo.jjd.patterns.chain;

import java.util.ArrayList;
import java.util.Arrays;

abstract class Handler implements IHandler{

    private IHandler nextHandler;
    private ArrayList<Priority> priority;

    public Handler(Priority... priority) {
        this.priority = new ArrayList<>(Arrays.asList(priority));
    }

    // устанавливает следующий обработчик
    @Override
    public IHandler setNext(IHandler handler) {
        nextHandler = handler;
        return nextHandler;
    }

    // проверка может ли обработчик обработать полученные данные/запрос, если не может,
    // то вызывает следующий обработчик и передает ему данные
    @Override
    public void handleRequest(Object someData, Priority priority) {
        // if (this.priority == priority) handlerAction(someData);
        if (this.priority.contains(priority)) handlerAction(someData);
        if (nextHandler != null) nextHandler.handleRequest(someData, priority);
    }

    // обработка данных, если он может
    abstract public void handlerAction(Object data);
}
