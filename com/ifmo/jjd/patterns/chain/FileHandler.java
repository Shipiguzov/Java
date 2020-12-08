package com.ifmo.jjd.patterns.chain;

public class FileHandler extends Handler{

    public FileHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("FileHandler: " + data);
    }
}
