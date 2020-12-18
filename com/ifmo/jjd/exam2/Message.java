package com.ifmo.jjd.exam2;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Message implements Serializable {

    private String text;
    private String sender;
    private LocalDateTime time;
    private boolean isConnected = true;
    private final static long serialVersionUID = 1L;

    public Message(String sender, boolean isConnected) {
        this.sender = sender;
        this.isConnected = isConnected;
    }

    public Message(String sender, String text) {
        setSender(sender);
        this.text = text;
    }

    public void setSender(String sender) {
        if (Objects.isNull(sender) || sender.length() < 3) throw new IllegalArgumentException("Sender name error");
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setTime() {
        this.time = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Message{" +
                ", time: " + time + "\n" +
                ", sender: '" + sender + "\'\n" +
                "text: '" + text + "\'\n" +
                '}';
    }
}
