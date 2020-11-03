package com.ifmo.jjd.lesson15.hw.message;

public enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int ord) {
        for (MessagePriority mp : values()) {
            if (ord == mp.ordinal()) {
                return mp;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}
