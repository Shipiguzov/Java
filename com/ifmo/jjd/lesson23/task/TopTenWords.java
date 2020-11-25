package com.ifmo.jjd.lesson23.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        // System.out.println(map);

        /*Files.lines(Paths.get("sourses/task23.txt"))
                .flatMap(str -> Arrays.stream(str.split(" ")))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                        )
                ).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                //.limit(10)
                .forEach(System.out::println);*/

        Map<String, Long> map = Arrays.stream(Files.readString(Paths.get("sourses/task23.txt")).split(" "))
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        TreeMap::new,
                        Collectors.counting()
                        )
                ).entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println(map);
    }
}




