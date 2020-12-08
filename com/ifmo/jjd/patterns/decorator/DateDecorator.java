package com.ifmo.jjd.patterns.decorator;

import java.time.LocalDateTime;

public class DateDecorator extends LoggerDecorator {

    public DateDecorator(ILogger logger) {
        super(logger);
    }

    @Override
    public void write(String data) {
        String dataWithDate = data + " " + LocalDateTime.now();
        super.write(dataWithDate);
    }
}
