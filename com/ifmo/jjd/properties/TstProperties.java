package com.ifmo.jjd.properties;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Properties;

public class TstProperties {
    public static void main(String[] args) {
        // ПКМ -> Mark directory -> Resources Root
        // Properties основан на hash таблице и используется
        // в основном для хранения настроек приложения.
        // Данные хранятся в парах: ключ - значение,
        // при этом ключ - строка, значение - строка

        // config.properties
        Properties properties = new Properties();
        properties.setProperty("someKey", "value");
        System.out.println(properties.getProperty("someKey"));
        System.out.println(properties.getOrDefault("key", "default"));

        try (InputStream input = TstProperties.class
                .getClassLoader().getResourceAsStream("config.properties")){
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(properties.getProperty("status"));
        System.out.println(properties.getProperty("code"));
        System.out.println(properties);


    }
}
