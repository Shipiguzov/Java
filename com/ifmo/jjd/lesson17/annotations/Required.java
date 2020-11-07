package com.ifmo.jjd.lesson17.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//
// @Target({ElementType.METHOD, ElementType.FIELD})
@Target(ElementType.FIELD) // данная аннотация работает для полей
@Retention(RetentionPolicy.RUNTIME) // аннотация сохраняется на момент выполнения программы (когда будет сохранена аннотация)
public @interface Required {
}
