package com.ifmo.jjd.patterns.chain;

public class ConsoleHandler extends Handler {

    public ConsoleHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("ConsoleHandler: " + data);
    }
}
