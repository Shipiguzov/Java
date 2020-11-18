package com.ifmo.jjd.lesson22;

import java.util.Comparator;
import java.util.function.Predicate;

public class LambdaCollections {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());

        System.out.println(university.getCourses());

        // компараторы
        // реализация метода compare
        Comparator<Course> byName = (c1, c2) -> c2.getName().compareToIgnoreCase(c1.getName());
        university.getCourses().sort(byName);

        // метод статический. На вход - объект Function: R apply(T t);
        byName = Comparator.comparing(course -> course.getName()); // заменяет среда вместо:  (c1, c2) -> c2.getName().compareTo(c1.getName())
        byName = Comparator.comparing(Course::getName);
        university.getCourses().sort(byName);
        // Разобраться с Generic на примере курсов и comparing и sort
        university.getCourses().sort(
                Comparator.comparing(Course::getName) // King::getGold - нельзя. Т.к. university содержит List Course
                        .thenComparing(Course::getDuration)
                        .thenComparing(Course::getPrice)
        );
        // removeIf
        university.getCourses().removeIf(course -> course.getDuration() < 2);
        university.getCourses().forEach(System.out::println);
        university.getCourses().forEach(course -> course.setDuration(course.getDuration() + 1));
    }
}
