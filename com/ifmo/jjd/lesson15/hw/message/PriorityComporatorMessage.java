package com.ifmo.jjd.lesson15.hw.message;

import java.util.Comparator;

public class PriorityComporatorMessage implements Comparator<Message> {

    @Override
    public int compare(Message o1, Message o2) {
        return Integer.compare(o1.getPriority().ordinal(), o2.getPriority().ordinal());
    }
}
