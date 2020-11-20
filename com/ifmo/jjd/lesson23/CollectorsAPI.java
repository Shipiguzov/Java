package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson22.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        System.out.println(courses);

        // Группировки. Collectors.groupingBy
        // Collector<T, ?, Map<K, List<T>>
        // Название - список курсов
        Map<String, List<Course>> byName = courses.stream()
                .collect(Collectors.groupingBy(Course::getName));// course -> course.getName
        // ArrayList<Course> ...
        // .collect(Collectors.groupingBy(Course::getName, Collectors.toCollection(ArrayList::new)));
        System.out.println(byName);

        // название - количество курсов
        Map<String, Long> coursesCount = courses.stream()
                .collect(Collectors.groupingBy(Course::getName, Collectors.counting()));
        System.out.println(coursesCount);

        // название - средняя стоимость
        Map<String, Double> coursesAvagangePrice = courses.stream()
                .collect(Collectors.groupingBy(Course::getName, Collectors.averagingDouble(Course::getPrice)));
        System.out.println(coursesAvagangePrice);

        // Map<название, Map<продолжительность, список курсов>>
        Map<String, Map<Integer, List<Course>>> nameDuration = courses.stream()
                .collect(Collectors.groupingBy(Course::getName,
                        Collectors.groupingBy(Course::getDuration)));
        System.out.println(nameDuration);

        List<String> coursesNames = courses.stream()
                .map(Course::getName) // course -> course.getName()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(coursesNames);
    }
}
