package com.ifmo.jjd.lesson17.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class TstAnnotations {
    public static void main(String[] args) {
        Class<SomeClass> someClass = SomeClass.class;

        // получение аннотаций
        Annotation[] annotations = someClass.getAnnotations();
        System.out.println(Arrays.toString(annotations));

        // проверка на наличие аннотации
        if (someClass.isAnnotationPresent(Config.class)) {
            System.out.println("Config.class");
            // ссылка на аннотацию someClass
            Config config = (Config) someClass.getDeclaredAnnotation(Config.class);
            System.out.println(config.desc());
            System.out.println(config.version());

        }

        Field[] fields = someClass.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Required.class)) {
                System.out.println("Required.class");
                // stringData -> setStringData(String data)
                // age -> setAge()
            }
        }

        // если класс аннотирован @Config, создать экземпляр данного класса,
        // используя рефлексию
        // если поле данного класса аннотировано @Required, установить
        // значение поля через сеттер для ранее созданного объекта,
        // используя рефлексию
        // вызвать метод toString у ранее созданного объекта,
        // используя рефлексию


    }
}
