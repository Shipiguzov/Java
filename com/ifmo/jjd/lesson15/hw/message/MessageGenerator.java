package com.ifmo.jjd.lesson15.hw.message;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class MessageGenerator {
    public static List<Message> generate(int num){
        if (num <= 0) {
            return Collections.emptyList();
        }

        Random random = new Random();
        List<Message> messages = new ArrayList<>(num);

//        values() - вернет массив констант
        int typesCount = MessagePriority.values().length;

        for (int i = 0; i < num; i++){
            messages.add(new Message(random.nextInt(10), MessagePriority.getPriority(random.nextInt(typesCount))));
        }

        return messages;
    }
}