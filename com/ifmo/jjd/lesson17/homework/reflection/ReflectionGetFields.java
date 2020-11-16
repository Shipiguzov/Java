package com.ifmo.jjd.lesson17.homework.reflection;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Objects;

public class ReflectionGetFields {

    protected static String toStringFields(Object o) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class<?> classLink = o.getClass();
        StringBuilder fieldsOfObjectString = new StringBuilder();
        if (isStringClassNamePrimitive(classLink)) return fieldsOfObjectString.append(o).append(" ").toString();
        else if (classLink.isArray()) return arrayManufacturing(o);
        fieldsOfObjectString.append(manufactingOfNonPrimitiveObject(o));
        /*else if (!isStringClassNamePrimitive(classLink.getSuperclass())) {
            Field[] fieldsOfObjectSuperclass;
            fieldsOfObjectSuperclass = classLink.getSuperclass().getDeclaredFields();
            for (Field fiedldofObjectSuperclass : fieldsOfObjectSuperclass) {
                System.out.println();
            }
            createSuperclassObject(o);
            fieldsOfObjectString.append(toStringFields(classLink.getSuperclass()));
        }*/
        return fieldsOfObjectString.toString();
    }

    private static String getFieldName(Field fieldOfObject) {
        return fieldOfObject.getName();
    }

    private static Constructor getClassConstructor(Object inputObject) throws NoSuchMethodException {
        Constructor constructorLink = inputObject.getClass().getConstructor();
        return constructorLink;
    }

    private static Object getValueClassField(Object inputObject, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Class classLink = inputObject.getClass();
        Field field = classLink.getDeclaredField(fieldName);
        return field.get(inputObject);

    }

    private static HashMap<String, Object> getListofFields(Object inputObject) {
        HashMap<String, Object> hashMapOfFields = new HashMap<>();
        Field[] fields = inputObject.getClass().getDeclaredFields();
        for (Field field : fields) {
            String fieldName = getFieldName(field);
            try {
                Object valueOfField = getValueClassField(inputObject, fieldName);
                hashMapOfFields.put(fieldName, valueOfField);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return hashMapOfFields;
    }

    private static Object createSuperclassObject(Object inputObject) throws NoSuchMethodException {
        Class classLink = inputObject.getClass();
        Constructor classConstructor = getClassConstructor(inputObject);
        HashMap<String, Object> mapFields = getListofFields(inputObject);
        System.out.println(classConstructor);
        System.out.println(mapFields);
        return null;
    }

    private static Boolean isStringClassNamePrimitive(Class<?> classLink) {
        String stringClassName = classLink.getName();
        String className = stringClassName.substring(stringClassName.lastIndexOf(".") + 1);
        for (PrimitiveClasses value : PrimitiveClasses.values()) {
            if (value.toString().equalsIgnoreCase(className)) return true;
        }
        return false;
    }

    private static String arrayManufacturing(Object o) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < Array.getLength(o); i++) {
            if (!isStringClassNamePrimitive(Array.get(o, i).getClass())) toStringFields(Array.get(o, i).getClass());
            if (Objects.nonNull(Array.get(o, i))) stringBuilder.append(toStringFields(Array.get(o, i)));
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    private static String manufactingOfNonPrimitiveObject(Object inputObject) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Class classLink = inputObject.getClass();
        StringBuilder fieldsOfObjectString = new StringBuilder();
        Field[] fieldsOfObject = classLink.getDeclaredFields();
        for (Field field : fieldsOfObject) {
            field.setAccessible(true);
            if (field.getType().isArray()) fieldsOfObjectString.append(arrayManufacturing(field.get(inputObject)));
            else fieldsOfObjectString.append(field.getName()).append(": ").append(field.get(inputObject)).append(" | ");
        }
        return null;
    }
}
