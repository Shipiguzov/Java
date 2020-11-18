package com.ifmo.jjd.lesson22;

import java.util.function.Predicate;

public class UniversitySorting {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());

        System.out.println(university.getCourses());

        Predicate<Course> duration = courses -> !(courses.getDuration() < 3);
        Predicate<Course> cost = course -> !(course.getPrice() < 20000);
        Predicate<Course> name = course -> !(course.getName().equals("JJD"));
        System.out.println("Duration less then 3");
        System.out.println(university.filtered(duration));
        System.out.println("Coast less 20000");
        System.out.println(university.filtered(cost));
        System.out.println("JJD courses");
        System.out.println(university.filtered(name));
        System.out.println("Duration less then 3 and coast less 20000");
        System.out.println(university.filtered(duration.or(cost)));
        System.out.println("Duration less then 3 and coast less 20000. And JJD courses");
        System.out.println(university.filtered((duration.or(cost)).and(name)));
        university.getCourses().forEach(course -> course.setPrice(course.getPrice() + 10000));
        System.out.println("Added 10000 to price of every courses");
        System.out.println(university.getCourses());
    }
}
