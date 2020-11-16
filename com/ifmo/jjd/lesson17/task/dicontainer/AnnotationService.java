package com.ifmo.jjd.lesson17.task.dicontainer;

import java.io.*;
import java.util.*;

public final class AnnotationService {

    // метод получает информацию для полей из файла
    public static Properties getPropertiesFromFile(String fileName){
        Properties properties = new Properties();
        try {
            try (InputStream input = AnnotationService.class.getClassLoader().getResourceAsStream(fileName)){
                properties.load(input);
                //AnnotationService.println(properties.toString()); for debugging
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    // вывод информации
    public static void println(String text) {
        System.out.println(text);
    }


}
