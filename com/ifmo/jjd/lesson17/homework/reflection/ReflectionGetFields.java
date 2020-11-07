package com.ifmo.jjd.lesson17.homework.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class ReflectionGetFields {

    protected static String toStringFields(Object o) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        if (o == null) return "null";
        Class<?> classLink = o.getClass();
        StringBuilder fieldsOfObjectString = new StringBuilder();
        if (isStringClassNamePrimitive(classLink)) return fieldsOfObjectString.append(o).append(" ").toString();
        else if (classLink.isArray()) return fieldsOfObjectString.append(arrayManufacturing(o)).toString();
        else return fieldsOfObjectString.append(manufactingOfNonPrimitiveObject(o)).toString();
    }

    private static Boolean isStringClassNamePrimitive(Class<?> classLink) {
        String stringClassName = classLink.getSimpleName();//Name().split("\\.");
        for (PrimitiveClasses value : PrimitiveClasses.values()) {
            if (value.toString().equalsIgnoreCase(stringClassName)) return true;
        }
        return false;
    }

    // TODO: сделать обработку массива из объектов типа Books
    private static String arrayManufacturing(Object inputObject) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[[");
        for (int i = 0; i < Array.getLength(inputObject); i++) {
            if (!Objects.nonNull(Array.get(inputObject, i))) {
                stringBuilder.append("null").append(" | ");
                continue;
            }
            if (isStringClassNamePrimitive(Array.get(inputObject, i).getClass())) {
                stringBuilder.append(i).append(" : ").append(Array.get(inputObject, i)).append(" | ");
                continue;
            }
            Field[] fields = Array.get(inputObject, i).getClass().getDeclaredFields();
            stringBuilder.append(getStringFields(fields, Array.get(inputObject, i)));
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }

    private static String manufactingOfNonPrimitiveObject(Object inputObject) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class classLink = inputObject.getClass();
        StringBuilder fieldsOfObjectString = new StringBuilder();
        Field[] fieldsOfObject = classLink.getDeclaredFields();
        fieldsOfObjectString.append(getStringFields(fieldsOfObject, inputObject));
        /*for (Field field : fieldsOfObject) {
            field.setAccessible(true);
            if (!isStringClassNamePrimitive(field.getClass())) {
                fieldsOfObjectString.append(field.getName()).append(" : ").append(toStringFields(field.get(inputObject))).append(" | ");
                continue;
            }
            if (field.getType().isArray()) fieldsOfObjectString.append(arrayManufacturing(field.get(inputObject)));
        }*/
        if (isSuperClass(classLink)) {
            fieldsOfObject = classLink.getFields();
            fieldsOfObjectString.append(getStringFields(fieldsOfObject, inputObject));
        }
        return fieldsOfObjectString.toString();
    }

    public static String getStringFields(Field[] fields, Object inputObject) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        StringBuilder fieldsOfObjectString = new StringBuilder();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!Objects.nonNull(field.get(inputObject))) {
                fieldsOfObjectString.append(field.getName()).append(" : ").append("null").append(" | ");
                continue;
            }
            if (isStringClassNamePrimitive(field.get(inputObject).getClass())) {
                fieldsOfObjectString.append(field.getName()).append(" : ").append(toStringFields(field.get(inputObject))).append(" | ");
                continue;
            }
            if (field.getType().isArray()) {
                Object temp = field.get(inputObject);
                fieldsOfObjectString.append(arrayManufacturing(field.get(inputObject)));
                continue;
            }
            fieldsOfObjectString.append(field.getName()).append(" [ ").append(toStringFields(field.get(inputObject))).append("] | ");
        }
        return fieldsOfObjectString.toString();
    }

    public static boolean isSuperClass(Class classLink) {
        if (Objects.nonNull(classLink.getSuperclass())) return true;
        return false;
    }
}
