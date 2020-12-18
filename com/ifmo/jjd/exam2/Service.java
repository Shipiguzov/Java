package com.ifmo.jjd.exam2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Service {

    public static Properties getPropertiesFromFile(String fileName) {
        Properties properties = new Properties();
        try (InputStream inputStream = Service.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return properties;
    }
}
