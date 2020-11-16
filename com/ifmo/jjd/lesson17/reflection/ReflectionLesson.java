package com.ifmo.jjd.lesson17.reflection;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class ReflectionLesson {
    public static void main(String[] args)
            throws
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException {
        /* Рефлексия - механизм, с помощью которого можно
         *  и получать информацию о классах, интерфейсах, полях и методах
         * во время выполнения программы.
         * Reflection API дает возможность создавать новые экземпляры
         * этих классов, вызывать методы, получать или устанавливать
         * значения полей */

        // Все классы в java являются объектами типа Class

        Class<String> stringClass = String.class;
        System.out.println(stringClass);

        Class integerClass = int.class;
        System.out.println(integerClass);

        Class<TextMessage> textMessageClass = TextMessage.class;
        System.out.println(textMessageClass);

        TextMessage textMessage = new TextMessage("Сообщение");
        textMessage.setText("Рефлексия");

        Class<? extends TextMessage> tmClass = textMessage.getClass();
        System.out.println(tmClass);

        // можно получить имя класса, имя пакета
        String className = textMessageClass.getName();
        String packageName = tmClass.getPackageName();

        // интерфейсы, которые имплементирует класс
        Class[] interfaces = tmClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        // getSuperclass() - вернет ссылку на родителя
        System.out.println(tmClass.getSuperclass()); // Message
        System.out.println(tmClass.getSuperclass().getSuperclass()); // Object
        System.out.println(tmClass.getSuperclass().getSuperclass().getSuperclass()); // null

        System.out.println(Arrays.toString(T.class.getInterfaces()));

        // доступ к компонентам класса
        // доступ к public полям класса, включая поля родителя
        Field[] fields = tmClass.getFields();
        System.out.println(Arrays.toString(fields));

        // доступ к полям класса, включая private и protected
        // но не включая поля родителя
        Field[] declaredFields = tmClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        // доступ к методам
        // доступ к public методам класса, включая методы родителя
        Method[] methods = tmClass.getMethods();

        System.out.println(Arrays.toString(methods));

        // доступ к методам класса, включая private и protected
        // но не включая методы родителя
        Method[] declaredMethods = tmClass.getDeclaredMethods();
        System.out.println(Arrays.toString(declaredMethods));

        // доступ к конструкторам
        Constructor[] constructors = tmClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        // получили ссылку на конструктор, который принимает на вход
        // аргумент типа String
        Constructor<? extends TextMessage> tmConstructor
                = tmClass.getDeclaredConstructor(String.class);
        // создание объекта типа TextMessage
        // public TextMessage(String title) { }
        TextMessage reflectMessage =
                 tmConstructor.newInstance("Reflect Message");

        Field field = tmClass.getDeclaredField("text");

        System.out.println(field.getType().getName()); // тип данных поля
        field.setAccessible(true);
        // field.get - вернет значение поля для переданного объекта
        System.out.println(field.get(reflectMessage));
        // field.set - установит значение поля для переданного объекта
        field.set(reflectMessage, "Новое значение поля");

        System.out.println(reflectMessage.getText());

        // private void printInfo (String prefix)
        Method method =
                tmClass.getDeclaredMethod("printInfo", String.class);
        method.setAccessible(true);
        // method.getParameterTypes();
        method.invoke(reflectMessage, "!!!");

        // Class, Field, Method
        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        System.out.println(isPrivate);





    }
    // A {
    //    @Ex B b
    // }
    // B {
    //    A a
    // }
    public static String toString(Object o){
        StringBuilder stringBuilder = new StringBuilder();
        // проверка o на null
        // проверка o на примитив, String, Обертки
        // -> stringBuilder.append(o);
        // проверка на массив, перебор
        // package java.lang.reflect Array
        // fori от 0 до getLength
        // Array.getLength(o)
        // Array.get(o, i)

        Field[] fields = o.getClass().getDeclaredFields();
        // перебор fields
        // toString(field.get(o))
        // -> stringBuilder
        //      .append(fields.getName())
        //      .append(": ")
        //      .append(toString(field.get(o)));

        return stringBuilder.toString();
    }
}
interface T extends F {}
interface F extends Comparable, Serializable {}
