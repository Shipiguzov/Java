package com.ifmo.jjd.lesson17.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    // параметры аннотаций:
    // String, примитивы (не обертки), перечисления(enum)
    String desc(); // без значения по умолчанию
    int version() default 1; // со значением по умолчанию
}
