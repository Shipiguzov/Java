package com.ifmo.jjd.multithreading.lesson27.hw;

import com.ifmo.jjd.lesson20.socketio.ServerCommand;
import com.ifmo.jjd.lesson20.socketio.SimpleMessage;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.Callable;

public class ProceccingMessage implements Callable {

    private SimpleMessage message;
    private int count;
    private LocalTime time;



    public ProceccingMessage(SimpleMessage message, int count, LocalTime time) {
        this.message = message;
        this.count = count;
        this.time = time;
    }

    private String helpCommand() {
        StringBuilder outputMessage = new StringBuilder();
        for (ServerCommand value : ServerCommand.values()) {
            outputMessage.append("/").append(value.toString().toLowerCase()).append(", ");
        }
        return outputMessage.toString();
    }

    private long pingCommand(SimpleMessage message, LocalTime time) {
        return ChronoUnit.MICROS.between(message.getDateTime().toLocalTime(), time);
    }

    @Override
    public String call() throws InterruptedException {
        Thread.sleep(3000);
        String command = message.getText().substring(1);
        if (ServerCommand.HELP.toString().toLowerCase().equals(command))
            return "/command: " + ServerCommand.HELP.toString().toLowerCase() + ". Aviable command: " + helpCommand();
        if (ServerCommand.COUNT.toString().toLowerCase().equals(command))
            return "/command: /" + ServerCommand.COUNT.toString().toLowerCase() + " Number of connections " + count;
        if (ServerCommand.PING.toString().toLowerCase().equalsIgnoreCase(command))
            return "/command: /" + ServerCommand.PING.toString().toLowerCase() + " Current ping: " + pingCommand(message, time) + " microseconds";
        return null;
    }
}
