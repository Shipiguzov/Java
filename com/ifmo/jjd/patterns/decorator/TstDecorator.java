package com.ifmo.jjd.patterns.decorator;

public class TstDecorator {
    public static void main(String[] args) {
        Logger baseLogger = new Logger();
        baseLogger.write("Message #1");

        ILogger addData = new DateDecorator(baseLogger);
        addData.write("Message #2");

        ILogger logger = new LevelDecorator(new DateDecorator( new Logger()));
        logger.write("Message #3");
        // LevelDecorator: "Message #3 + число
        //
    }
}


// класс с основным функционалом
// class Logger

// декораторы
// базовый декоратор - LoggerDecorator

// классы с основным функционалом и декораторы должны имплементировать один и тот же интерфейс

// конкретные декораторы - DateDecorator