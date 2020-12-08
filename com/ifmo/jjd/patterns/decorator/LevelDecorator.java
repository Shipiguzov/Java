package com.ifmo.jjd.patterns.decorator;

public class LevelDecorator extends LoggerDecorator{

    private int level;

    public LevelDecorator(ILogger logger, int level) {
        super(logger);
        this.level = level;
    }

    public LevelDecorator(ILogger logger) {
        super(logger);
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public void write(String data) {
        String newData = data + " " + Math.random(); // + level
        super.write(newData);
    }
}
