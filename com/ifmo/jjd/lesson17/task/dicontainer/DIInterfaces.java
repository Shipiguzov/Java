package com.ifmo.jjd.lesson17.task.dicontainer;

import com.ifmo.jjd.lesson17.task.fortest.Cat;
import com.ifmo.jjd.lesson17.task.fortest.Mouse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Properties;

public interface DIInterfaces {

    // Создает экземпляр данного класса
    Object createObject(Class<?> classLink) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException;

    // Получает конструктор данного класса
    Constructor<?> getClassConstructor(Class<?> classLink);

    // Проверка класса на аннотацию @ConfigClass
    boolean checkConfigClassAnnotation(Class<?> classLink);

    // Создание объекта с аннотацией @ConfigClass
    Object createObjectFromFile(Class<?> classLink);

    // Проверка класса на аннотацию @RequiredClass
    boolean checkRequiredClassAnnotation(Class<?> classLink);

    // Проверка поля на аннотацию @RequiredField
    boolean checkRequiredFieldAnnotation(Field fieldLink);

    // Проверка является ли поле примитивом
    boolean isFieldPrimitive(String objectName);

    // Заполняет поля из файла
    Object fillFieldsFromFile(Object inputObject) throws IllegalAccessException;

    // Возвращает объект данного класса
    <T> T getObject(String className);
}
