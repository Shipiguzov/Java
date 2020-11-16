package com.ifmo.jjd.lesson20.serialization;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        Pupil pupil1 = new Pupil();
        pupil1.setAge(7);
        pupil1.setName("pupil1");
        pupil1.setGroup(new Group("Химия", 12));
        pupil1.learn();

        Pupil pupil2 = new Pupil();
        pupil2.setAge(8);
        pupil2.setName("pupil2");
        pupil2.setGroup(new Group("Биология", 22));
        pupil2.learn();

        Director director = new Director("Super Speech");
        director.setAge(44);
        director.setName("director");
        director.setRating(2);

        System.out.println(pupil1);
        System.out.println(pupil2);
        System.out.println(director);

        File file = new File("school.bin");
        objectToFile(file, pupil1);
        objectToFile(file, pupil2);
        Pupil pupilFromFile1 = (Pupil) objectFromFile(file);
        Pupil pupilFromFile2 = (Pupil) objectFromFile(file);
        System.out.println(pupilFromFile1);
        System.out.println(pupilFromFile2);
        System.out.println(pupil1.equals(pupilFromFile1));
        System.out.println(pupil2.equals(pupilFromFile2));


        // объект представить как последовательность байт - процесс сериализации
        // ObjectOutputSteam

        // десериализация - процесс преобразования последовательности байт в объект (в не зависимости от класса первоначального объекта
        // получим тип Object
        // ObjectInputStream
        // ObjectOutputSteam и ObjectInputStream - декораторы, соответственно
        // в конструктор ObjectInputStream мы должны передать InputStream
        // в конструктор ObjectOutputStream мы должны передать OutputStream

        // объект -> последовательность байт -> файл
        // файл -> последовательность байт -> объект

        // для сериализации и десериализации классы должны имплетировать один из интерфейсов java.io.Serializable (интерфейс-маркер)
        // либо интерфейс java.io.Externalizable
        // если они не имплементирован, тогда при сериализации / десериализации будет exception
        // Serializable позволяет исключить поля из процесса сериализации (по умолчанию сериализуются все поля)
        // Externalizable - по умолчанию не сериализуется ни одно поле (есть возможность указания полей для сериализации). Надо переопределить 2 метода

        // так же при сериализации / десериализации, кроме значения полей, добавляется версия класса
        // если версия класса изменилось между сериализацией и десериализацией, тогда exception
        // при сериализации сохраняется информация: сам класс, родители, поля (сторится граф объектов(связь класса с другими объектами,
        // их связи с др. объектами и т.д.), версия класса

        // если Interface пустой (который имплементируем) - то это называется маркерный интерфейс

        // Serialazible
        // если имплементация интерфейса будет у дочернего класса, то полученные от родителя поля не будут участвовать в сериализации
        // при десериализации мы получим значения по умолчанию по этим полям
        // если имплементация интерфейса будет у родительского класса, то все его потомки будут Serialazible классами
        // свойства, отмеченные transient не участвуют в сериализации (как для родителя, так и для потомков (если потомок заимствует
        // transient  поле родителя, то оно не будет участвовать в сериализации))


    }

    public static void objectToFile(File file, Object object) {
        try (FileOutputStream fileStream = new FileOutputStream(file, true);
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileStream)) {
            objectOutput.writeObject(object);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("FileNotFoundException");
        } catch (IOException ioException) {
            System.out.println("IOExeption");
        }
    }

    public static Object objectFromFile(File file) {
        Object o = null;
        try (FileInputStream fileStream = new FileInputStream(file); // чтение из файла
             ObjectInputStream objectInput = new ObjectInputStream(fileStream)) { // десериализация
            o = objectInput.readObject(); // ClassNotFoundException
        } catch (FileNotFoundException ignored) {
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return o;
    }
}

/*class Some<T> {
    public void write(T o) {

    }
    public <T> read() {
        return null;
    }
}*/
