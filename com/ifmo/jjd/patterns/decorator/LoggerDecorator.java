package com.ifmo.jjd.patterns.decorator;

public class LoggerDecorator implements ILogger {

    private ILogger logger;

    public LoggerDecorator(ILogger logger) {
        this.logger = logger;
    }

    @Override
    public void write(String data) {
        logger.write(data);
    }
}
