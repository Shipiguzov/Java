package src.com.ifmo.jjd.lesson12.exceptions;

import java.io.IOException;
import java.util.Objects;

public class ExeptionLesson {
    public static void main(String[] args) {
        /* Все ошибки и exteprion являются объектами
        * Error - ошибки, связанные с проблемами уровня JVM, например ошибка нехватки памяти.
        * Ошибки (все Error) не следует обрабатывать в программе*/

        /* Exception - исключения. Все исключения можно предугадать и обработать.
        * При этом некоторые из них разработчики обязаны обработать в своей прогамме.*/

        /* Все исключения делятся на:
        * 1. Исключения времени выполнения (возникают во время выполнения программы) (наследники RuntimeException
        * могут называться: unchecked / необрабатываемые / неотслеживаемые / неконтролируемые
        * Исключения данного типа можно обработать в программе, а можно и не обрабатывать.
        * 2. Все остальные исключения (не наследник RuntimeException) - исключения времени компиляции.
        * могут называться : checked / отслеживаемые / обрабатываемые / контролируемые
        * исключения данного типа разработчики ОБЯЗАНЫ обработать в программе
        * */

        // RuntimeExceptions:
        int a = 30;
        int b = 0;
        int res;
        //res = a / b; // деление на 0 java.lang.ArithmeticException

        int[] ints = new int[3];
        //ints[100] = 90; // java.lang.ArrayIndexOutOfBoundsException

        String s = null;
        //s.equals("data"); // java.lang.NullPointerException

        Object data = "123";
        // Integer integer = (Integer) data; // java.lang.ClassCastException - невозможно приведение типов

        // обработка исключений (checked и unchecked)
        // для обработки исключений используется try catch блок и блок  finally

        try { // в блок try помещается потенциально опасный код, который может привести к исключению
            res = a / b; // когда a / b приведет к java.lang.ArithmeticException управление перейдет в блок catch,
            // остальной код в блоке try выполнен не будет
        } catch (ArithmeticException e) { // перехватывает только то исключение, которое указано в ().
            // В данном случае исключение типа ArithmeticException
            // ArithmeticException - тип данных исключения (класс объекта исключения)
            // e - объект исключения (объект типа ArithmeticException)

            // перечисляем инструкции, которые должны быть выполнены при ArithmeticException и всех его потомков
            System.out.println(e.getMessage()); // информация об исключении (сообщение / by zero)
            e.printStackTrace();

            res = 100;
        }
        System.out.println("ater java.lang.ArithmeticException " + res);

        // объединение  catch блоков, если есть необходимость обработать несколько исключений
        // 1. несколько блоков catch - позволяет обрабатывать разные исключения разными способами.
        try {
            if (System.currentTimeMillis() % 2 == 00) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException e) { // перехватит ClassCastException и всех его потомков
            System.out.println("Проблема с приведением");
        } catch (ArrayIndexOutOfBoundsException e) { // перехватит ArrayIndexOutOfBoundsException и всех его потомков
            System.out.println("Проблема с массивом");
        }

        // 2. Все исключения необходимо обработать одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 00) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Проблема с массивом или приведением");
        }
        // 3. Через общего родителя.
        try {
            if (System.currentTimeMillis() % 2 == 00) data = (Integer) data;
            else ints[100] = 90;
        } catch (RuntimeException e) {
            System.out.println("Проблема с чем то");
        }

        try {
            if (System.currentTimeMillis() % 2 == 00) data = (Integer) data;
            else ints[100] = 90;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Проблема с массивом или приведением");
        } catch (RuntimeException e) {
            System.out.println("Проблема с чем то");
        }
        // дополнительный блок finally
        finally {
            // Код, который написан в блоке finally выполнится в случае любого исключения, даже если оно не перехватываеся
            // в блоке catch
            System.out.println("Закрытие ресурсов в блоке finally");
        }

        //
        try {
            voidWithChecjedEx("file.json");
        } catch (IOException e) {
            e.getStackTrace();
        }

        try {
            // переменная message объявленая в блоке {}, значит её область видимости ограничена данным блоком
            Message message = new Message("T");
        } catch (ChatException e) {
            System.out.println(e.getMessage());
            try {
                throw new ChatException("in catch").initCause(e);
            } catch (Throwable e1) {
                e.printStackTrace();
            }
        }
    }

    // обрабатываемые исключение ОБЯЗАНЫ быть обработанными. Либо в try - catch, либо в сигнатуре метода.
    // ниже - в сигнатуре метода. Т.е. обработать исключение должен тот, кто вызывает данный метод.
    public static void voidWithChecjedEx(String fileName) throws IOException {
        // генерируем и выбрасываем обрабатываемое исключение
        if (fileName.endsWith("json")) throw new IOException("Проблема с файлом");
    }
}
