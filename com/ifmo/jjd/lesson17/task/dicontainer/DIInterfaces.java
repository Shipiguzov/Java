package com.ifmo.jjd.lesson17.task.dicontainer;

import com.ifmo.jjd.lesson17.task.fortest.Cat;
import com.ifmo.jjd.lesson17.task.fortest.Mouse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public interface DIInterfaces {

    // Создает экземпляр данного класса
    public Object createObject(Class<?> classLink) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException;

    // Получает конструктор данного класса
    public Constructor<?> getClassConstructor(Class<?> classLink);

    // Проверка класса на аннотацию @ConfigClass
    public boolean checkConfigClassAnnotation(Class<?> classLink);

    // Создание объекта с аннотацией @ConfigClass
    public Object createObjectFromFile(Class<?> classLink);

    // Проверка класса на аннотацию @RequiredClass
    public boolean checkRequiredClassAnnotation(Class<?> classLink);

    // Проверка поля на аннотацию @RequiredField
    public boolean checkRequiredFieldAnnotation(Field fieldLink);

    // Проверка является ли поле примитивом
    public boolean isFieldPrimitive(String objectName);

    // Заполняет поля из файла
    public Object fillFieldsFromFile(Object inputObject) throws IllegalAccessException;

    // Возвращает объект данного класса
    public Object getObject(String className);

    // Возвращает объект класса Cat
    public Cat getCat(Object o);

    // Возвращает объект класса Mouse
    public Mouse getMouse(Object o);
}
