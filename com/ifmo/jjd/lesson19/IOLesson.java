package com.ifmo.jjd.lesson19;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Field;

/**
 * Класс IOLesson
 * @author Ifmo
 * @version 1.1
 */

public class IOLesson {
    public static void main(String[] args) {
        // пакеты IO / NIO
        // IO предоставляет возможность передавать данные в виде последовательности byte либо последовательности char

        File file = new File("somefile.txt");

        try {
            file.createNewFile(); // создание файла. метод возвращает true / false в зависимости от того, удалось создать файл или нет
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists()); // существует файл или нет существует true /  false
        // является ли директорией
        System.out.println(file.isDirectory());
        // является ли файлом
        System.out.println(file.isFile());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.canExecute());// файл исполняемый или нет

        // если надо работать с файловой системой, тогда берем классы из пакета NIO
        // список файлов в директории
        File[] files = new File("sourses").listFiles();

        File lessonFile = new File("sourses/lesson19.txt");
        // если пишем в несуществующий файл, то он будет создан. Если существует - то перезапишет
        // если собираемся читать из несуществующего файла - exeption
        // 1. Если программа передает данные, используем наследников OutputStream
        // 2. Если программа получает данные, используем наследников InputStream

        try {
            writeToFile(lessonFile, "строка для записи", false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(readFromFile(lessonFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод записи в файл
     *
     * @param file   файл для записи
     * @param append флаг
     *               если значение true, запись в конец файла
     *               если значение false, запись в начало файла
     * @param data   данные String для записи в файл
     * @return - пишут, если метод что то возвращает
     * @throws IOException - файл не найден (не удалось создать файл),
     *                     проблема во время записи
     */

    // программа -> файл
    private static void writeToFile(File file, String data, boolean append) throws IOException {
        // try-with-sourse
        // когда выполнение блока try завершиться (с исключением или без него), у объектов, созданных в () будет вызван метод close()
        // Для создания объектов внутри () необходимо имплементация интерфейса AutoCloseable и реализация метода close()
        // Если код внутри try приводит к exception, тогда перед переходом к блоку catch - закрытие ресурсов. Если есть блок finally
        // тогда закрытие - после выполнения блока catch. Закрываем не в блоке catch
        try (FileOutputStream outputStream = new FileOutputStream(file, append)) {
            byte[] bytes = data.getBytes(); // преобразование строки в массив байт
            outputStream.write(bytes); // запись массива байт в файл
        }
    }

    // программа -> буфер (BufferedOutputStream) -> файл (FileOutputStream)
    public static void writeWithBuffer(File file) throws IOException {
        // у конструктора new FileOutputStream(file) флаг append = false - запись в начало
        // BufferedOutputStream в конструктор принимает любой объект OutputStream, когда буфер наполнится, он сам принимает решение о
        // передачи данных в объект, который указан при создании объекта BufferedOutputStream, а он уже делает с этими данными что должен делать
        try (FileOutputStream outputStream = new FileOutputStream(file);
             // BufferedOutputStream(OutputStream out, int size), где size - размер буфера. По умолчани.. 8192
             // BufferedOutputStream buffer = new BufferedOutputStream(new FileOutputStream()) - обычно записывают так
             BufferedOutputStream buffer = new BufferedOutputStream(outputStream)) {
            // BufferedOutputStream является декоратором по отношению к FileOutputStream
            for (int i = 0; i < 100_000; i++) {
                buffer.write((i + " ").getBytes());
            }
        }

        // при написании собственных декораторов для IO, классы-декораторы должны наследоваться от FilterOutputStream / FilterInputStream
    }

    /**
     * Метод чтения из файла
     *
     * @param file файл, содержимое которого нужно прочитать
     * @return строка, прочитанная из файла
     * @throws IOException файл не найден, проблема во время чтения
     */
    public static String readFromFile(File file) throws IOException {
        // метод read читает в какой то объект (массив байт)
        String res = null;
        try (FileInputStream fileInputStream = new FileInputStream(file);
             // BufferedInputStream buffer = new BufferedInputStream(fileInputStream);
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()
        ) {
            byte[] bytes = new byte[300];
            int data;

            while ((data = fileInputStream.read(bytes)) != -1) {
                // read возвращает количество прочитанных байт или -1, если нечего читать
                // native метод - написан на другом языке программирования
                byteArray.write(bytes, 0, data);
            }

            res = new String(byteArray.toByteArray());
        }
        return res;
    }

    // img -> byte[] ---передача--- byte[] -> img

    public static boolean byteArrayToImg(File file, byte[] bytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        BufferedImage image = ImageIO.read(inputStream);
        return ImageIO.write(image, "jpg", file);
    }

    public static byte[] imgToByteArray(File file) throws IOException {
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", outputStream);
        return outputStream.toByteArray();
    }
}

class SomeIODecorator extends FilterOutputStream {

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public SomeIODecorator(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        // шифрование xor ^ исользуя буфер
        // xor ^ - разобраться самому по этому шифрованию
        super.write(b);
    }
}

class SomeInputDecorator extends FilterInputStream {

    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected SomeInputDecorator(InputStream in) {
        super(in);
    }

    // file -> [23, 5, 67] -> декодируем массив [23, 5, 67]

    @Override
    public int read(byte[] b) throws IOException {
        //
        in.read(b); // read возвращает количество прочитанных байт
        // b - декодируем в цикле for и оставляем
        // return количество_прочитанных_байт;
        return 0;
    }
}
