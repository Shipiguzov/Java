package com.ifmo.jjd.lesson15.hw.message;

import java.util.*;

public class MessageTask {
    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = new ArrayList<>();
        messages.addAll(MessageGenerator.generate(5));
        System.out.println(messages);
        countEachPriority(messages);
        countEachCode(messages);
        System.out.println("Number of unique message: " + uniqueMessageCount(messages).size());
        System.out.println(uniqueMessagesInOriginalOrder(messages));
        System.out.println("Original message list: " + messages);
        System.out.println("List of messages without " + MessagePriority.getPriority(0) + ": " + removeEach(messages, MessagePriority.LOW));
        removeOther(messages, MessagePriority.LOW);
    }

    public static List<Message> sortList(List<Message> messageList) {
        Comparator<Message> priorityComparator = new PriorityComporatorMessage();
        messageList.sort(priorityComparator);
        return messageList;
    }

    public static void countEachPriority(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        for (int i = 0; i < MessagePriority.values().length; i++) {
            ArrayList<Message> messagePriority = new ArrayList<>();
            for (Message message : messageList) {
                if (message.getPriority() == MessagePriority.getPriority(i)) {
                    messagePriority.add(message);
                }
            }
            System.out.println("Количество сообщений для приоритета " + MessagePriority.getPriority(i) + ": " + messagePriority.size());
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        HashSet<Integer> uniqueCodeMesseges = uniqueCodeMessages(messageList);
        for (Integer uniqueCodeMessege : uniqueCodeMesseges) {
            int count = 0;
            for (Message message : messageList) {
                if (uniqueCodeMessege == message.getCode()) count++;
            }
            System.out.println("Code " + uniqueCodeMessege + " contins " + count + " times.");
        }
    }

    // делает Set уникальных кодов message из messageList
    private static HashSet<Integer> uniqueCodeMessages(List<Message> messageList) {
        HashSet<Integer> uniqueCodeMesages = new HashSet<>();
        for (Message message : messageList) {
            uniqueCodeMesages.add(message.getCode());
        }
        return uniqueCodeMesages;
    }

    private static HashSet<Message> uniqueMessageCount(List<Message> messageList) {
        // Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> uniqueMessagesList = new HashSet<>();
        for (Message message : messageList) {
            uniqueMessagesList.add(message);
        }
        return uniqueMessagesList;
    }

    public static LinkedHashSet<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> linkedHashSet = new LinkedHashSet<>();
        for (Message message : messageList) {
            linkedHashSet.add(message);
        }
        return linkedHashSet;
    }

    public static List<Message> removeEach(List<Message> messageList, MessagePriority priority) {
        // удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        List<Message> resultMessagesList = new ArrayList<>();
        resultMessagesList.addAll(messageList);
        for (Message message : messageList) {
            if (message.getPriority().equals(priority)) {
                resultMessagesList.remove(message);
            }
        }
        return resultMessagesList;
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        List<Message> resultMessagesList = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority() == priority) resultMessagesList.add(message);
        }
        System.out.println("Original message list: " + messageList);
        System.out.println("Messages with " + priority + ": " + resultMessagesList);
    }

}
