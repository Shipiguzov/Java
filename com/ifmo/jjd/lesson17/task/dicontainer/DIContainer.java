package com.ifmo.jjd.lesson17.task.dicontainer;

import com.ifmo.jjd.lesson17.homework.reflection.PrimitiveClasses;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.ConfigClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredClass;
import com.ifmo.jjd.lesson17.task.dicontainer.marks.RequiredField;
import com.ifmo.jjd.lesson17.task.fortest.Cat;
import com.ifmo.jjd.lesson17.task.fortest.Mouse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public final class DIContainer implements DIInterfaces {
    Set<Class> classesSet = new HashSet<>();
    Set<Object> container = new HashSet<>();

    /**
     * Constructor create a new DIContainer with set of class links
     *
     * @param classesSet set that pull into this.classesSet
     */
    public DIContainer(Set<Class> classesSet) {
        this.setClassesSet(classesSet);
    }

    /**
     * Method declare classesSet and check it for NULL
     *
     * @param classesSet set that pull into this.classesSet
     * @throws IllegalArgumentException if set consist NULL
     */
    public void setClassesSet(Set<Class> classesSet) {
        for (Class aClass : classesSet) {
            if (Objects.isNull(aClass)) throw new IllegalArgumentException("Set consist NULL");
        }
        this.classesSet.addAll(classesSet);
    }

    public void run() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        for (Class aClass : classesSet) {
            if (checkRequiredClassAnnotation(aClass)) {
                container.add(createObject(aClass));
                continue;
            }
        }
        getCat(getObject("cat")).catchMouse(getMouse(getObject("mouse")));
        AnnotationService.println(container.toString());
    }

    @Override
    public Object createObject(Class<?> classLink) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Object object = null;

        if (checkConfigClassAnnotation(classLink)) {
            object = createObjectFromFile(classLink);
            object = fillFieldsFromFile(object);
            return object;
        }

        if (checkRequiredClassAnnotation(classLink)) {

            // Create object
            Constructor classConstructor = classLink.getDeclaredConstructor();
            object = classConstructor.newInstance();

            Field[] fieldsInputClass = classLink.getDeclaredFields();
            for (Field field : fieldsInputClass) {
                if (checkRequiredFieldAnnotation(field)) {
                    field.setAccessible(true);
                    if (!isFieldPrimitive(field.getName())) {
                        field.set(object, createObject(field.getType()));
                    }
                } else {
                    String fieldName = field.getName();
                    fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                    field.setAccessible(true);
                    try {
                        Method method = classLink.getDeclaredMethod("set" + fieldName);
                        method.invoke(object);
                    } catch (NoSuchMethodException ignored) {
                    }
                }
            }
        }
        return object;
    }

    @Override
    public Constructor<?> getClassConstructor(Class<?> classLink) {
        Constructor<?> constructor = null;
        try {
            constructor = classLink.getDeclaredConstructor();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return constructor;
    }

    @Override
    public boolean checkConfigClassAnnotation(Class<?> classLink) {
        return classLink.isAnnotationPresent(ConfigClass.class);
    }

    @Override
    public Object createObjectFromFile(Class<?> classLink) {
        Object object = null;
        Constructor constructor = getClassConstructor(classLink);
        try {
            object = constructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        try {
            return fillFieldsFromFile(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    @Override
    public boolean checkRequiredClassAnnotation(Class<?> classLink) {
        return classLink.isAnnotationPresent(RequiredClass.class);
    }

    @Override
    public boolean checkRequiredFieldAnnotation(Field fieldLink) {
        return fieldLink.isAnnotationPresent(RequiredField.class);
    }

    @Override
    public boolean isFieldPrimitive(String objectName) {
        for (PrimitiveClasses value : PrimitiveClasses.values()) {
            if (value.toString().equalsIgnoreCase(objectName)) return true;
        }
        return false;
    }

    @Override
    public Object fillFieldsFromFile(Object inputObject) throws IllegalAccessException {

        Properties properties = AnnotationService.getPropertiesFromFile(inputObject.getClass().getAnnotation(ConfigClass.class).file());
        Field[] fields = inputObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            for (Map.Entry<Object, Object> objectObjectEntry : properties.entrySet()) {
                String propertiesName = objectObjectEntry.getKey().toString();
                int index = propertiesName.indexOf(".") + 1;
                propertiesName = propertiesName.substring(index);

                if (propertiesName.equalsIgnoreCase(field.getName())) {
                    field.setAccessible(true);
                    if (field.getType().isPrimitive())
                        field.set(inputObject, Integer.valueOf(objectObjectEntry.getValue().toString()));
                    else field.set(inputObject, objectObjectEntry.getValue().toString());
                }
            }
        }

        return inputObject;
    }

    @Override
    public Object getObject(String className) {
        for (Object o : container) {
            if (className.equalsIgnoreCase(o.getClass().getSimpleName())) return o;
        }
        return null;
    }

    @Override
    public Cat getCat(Object o) {
        return (Cat) o;
    }

    @Override
    public Mouse getMouse(Object o) {
        return (Mouse) o;
    }

}
