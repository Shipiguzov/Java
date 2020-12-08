package com.ifmo.jjd.patterns.chain;

public class DBHandler extends Handler{

    public DBHandler(Priority... priority) {
        super(priority);
    }

    @Override
    public void handlerAction(Object data) {
        System.out.println("DBHandler: " + data);
    }
}
