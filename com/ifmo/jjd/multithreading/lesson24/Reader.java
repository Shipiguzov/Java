package com.ifmo.jjd.multithreading.lesson24;

import com.ifmo.jjd.lesson22.Course;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reader implements Runnable{
    private CopyOnWriteArrayList<Course> courses;

    public Reader(CopyOnWriteArrayList<Course> courses) {
        this.courses = courses;
//        Thread.sleep(5000);
    }

    @Override
    public void run() {
        // "lesson24.txt"
        while (true) {
            Course course = courses.stream()
                    .min(Comparator.comparing(Course::getDuration))
                    .orElse(Course.getInstance());
            String forFile = Thread.currentThread().getName() + ": " + course + "\n";
            try {
                Files.write(Paths.get("sources/lesson24.txt"), forFile.getBytes(),
                        StandardOpenOption.APPEND);
                courses.remove(course);

                Thread.sleep(5000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
