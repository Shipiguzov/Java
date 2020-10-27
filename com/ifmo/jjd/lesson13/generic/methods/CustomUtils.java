package com.ifmo.jjd.lesson13.generic.methods;

public class CustomUtils {

    // Типизированные методы generic methods
    // Могут быть static и не static
    // Если тип generic (T) ничем не ограничен, то при компиляции он будет преобразовываться в Object
    // Это называется стирание типов. Ничего не теряется, можно будет вернуть всё обратно
    // Соответственно можем использовать только методы класса Object
    // (Тип данных на момент написания метода не определен. Данные параметров преобразуются в класс Object)


    public static <T> boolean inArray(T[] arr, T elem) {
        if (elem == null) throw new IllegalArgumentException("elem must be not null");
        for (T s : arr) {
            if (elem.equals(s)) return true;
        }
        return false;
    }

    // extends - ограничение типов, тип T может быть типом Number или любым другим типом, который его расширяет
    // аналогично и для типа К
    // доступны методы класса, который ограничивает типы.
    public static <T extends Number, K extends Number> int compareHashCode(T first, K second) {
        return Integer.compare(first.hashCode(), second.hashCode());
    }
}
