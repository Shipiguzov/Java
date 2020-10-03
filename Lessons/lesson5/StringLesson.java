package Lessons.lesson5;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Objects;

public class StringLesson {
    public static void main(String[] args) {
        // char - символьный тип
        // char - один 16 битный символ Unicode
        // 0 .. 65536 (\u0000 до \uffff - в 16тиричной системе)
        // можно задать:
        char char1 = 'J';// сам символ в одинарных кавычках
        char char2 = 74;// номер символа
        char char3 = '\u0044';// шестнадцатиричное представление в escape последовательности
        System.out.print(char1);// J
        System.out.print(char2);// J
        System.out.print(char3);// D

        System.out.println("\nСтроки");
        // Строка - упорядоченная последовательность символов
        // Строки - объекты (ссылочный тип) класса String
        // Строки задаются:
        //      в ""
        //      используя new String() - им пользуются, если нельзя воспользоваться предыдущем вариантом
        // Строки нелья изменить, можно только создать новую на основе существующей
        // Все строковые литералы,
        // например System.out.println("\nСтроки"); реализованы как экземпляры String

        char[] jjdChars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(jjdChars);
        jjdString = "\u004A\u004A\u0044";
        System.out.println(jjdChars); // JJD
        System.out.println(jjdString.length()); // 3
        System.out.println(jjdString.codePoints().count()); // 3

        char[] frogChars = {'\uD83D', '\uDC38'};
        String frogString = new String(frogChars);
        frogString = "\uD83D\uDC38";
        // 1101 1000 0011 1101 .. 1101 1100 0011 1000
        System.out.println(frogString); // 🐸
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); // 1

        // каждый символ Unicode может быть представлен
        // одним или парой (суррогатная пара) чаров

        // хранение строк до java 9: массив char[] в кодировке UTF-16, при этом каждый char был представлен двумя байтами

        // хранение строк начиная с java 9: массив byte[] + кодировка UTF-16 или LATIN1

        System.out.println("Пул строк");
        // пул строк (находится в heap памяти) хранит только одну копию каждого строкового литерала.
        // Строки в пуле строк не дубируются
        // Интернирование - помещение строки в пул строк
        String string1 = "Строка";
        String string2 = "Строка";
        String string3 = new String("Строка"); // строка создается не в пуле памяти. Объекты там могут повторяться и занимать память

        System.out.println(string1 == string2); // true //проверка ссылки на один объект в памяти
        System.out.println(string1 == string3); // false

        System.out.println("Метод intern()");
        String internStr = string3.intern(); // string3 так и останется в памяти там, где и был
        System.out.println(string1 == internStr); // true
        System.out.println(string3 == internStr); // false
        System.out.println(string2 == internStr); // true

        System.out.println("Сравнение строк");
        // equals()
        string1 = "Строка";
        string2 = "Строка";
        System.out.println(string1.equals(string2)); // true
        System.out.println("строка".equals(string1)); // false
        System.out.println("строка".equalsIgnoreCase(string1)); // true

        // вариант "строка".equals(string1); - лучше, чем
        // string1.equals("строка");

        String nullString = null;
        System.out.println("строка".equals(nullString)); // false
        // System.out.println(nullString.equals("строка")); // java.lang.NullPointerException

        System.out.println(nullString == null); // true
        System.out.println(Objects.nonNull(nullString)); // false
        System.out.println(Objects.isNull(nullString)); // true

        // дан массив animals {"кот", "пёс", "гусь"}
        // создать новый массив (количество элементов, больше, чем у anumals в 2 раза)
        // заполнить новый массив рандомными значенниями из массива animals

        String[] animals = {"кот", "пёс", "гусь"};
        String[] resultArray = new String[animals.length * 2];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = animals[(int) (Math.random() * animals.length)];
        }
        System.out.println(Arrays.toString(resultArray));

        System.out.println("Конкатенация строк");
        string1 = "Java";
        string2 = "Python";

        // 1 вариант: +
        System.out.println(string1 + " :: " + string2);

        // 2 вариант: строка.concat(" :: ")
        String concatStr = string1.concat(" :: ").concat(string2);
        System.out.println(concatStr);

        // 3 вариант: String.join(разделитель, строка1, строка2, ..., строка N);
        concatStr = String.join(" :: ", string1, string2);
        System.out.println(concatStr);

        System.out.println("Буферизированные строки");
        concatStr = "";
        for (int i = 0; i < 10; i++) {
            concatStr += i + " ";
        }
        System.out.println(concatStr);
        // конкатинация в цикле - ресурсоёмко и пользоваться не рекомендуется

        // StringBuilder - работает быстрее, но не является потокобезопасным
        // StringBuffer - работает медленее, но потокобезопасным

        StringBuilder sb = new StringBuilder(string1);
        sb.append(" :: ").append("Python");
        concatStr = sb.toString();
        System.out.println(concatStr);

        sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i).append(" ");
        }
        concatStr = sb.toString();
        System.out.println(concatStr);

        // Сравнение строк по номерам символов из таблицы Unicode
        // С: 1057 с: 1089
        System.out.println();

        System.out.println("строка".compareTo("строка")); // 0
        System.out.println("строка".compareTo("Строка")); // 32
        System.out.println("Строка".compareTo("строка")); // -32
        System.out.println("строка".compareToIgnoreCase("Строка")); // 0

        // start / end
        string1 = "JJD";
        System.out.println(string1.startsWith("JJ")); // true
        System.out.println(string1.startsWith("D", 2)); // true (если выходит за пределы, тогда возвращает false)
        System.out.println(string1.endsWith("d")); // false

        // Приведение к регистру
        string1 = string1.toLowerCase();
        string1 = string1.toUpperCase();

        // замена
        string1 = "JJD";
        string1 = string1.replace("J", "!");
        System.out.println(string1);
        string1 = "JJD";
        string1 = string1.replaceAll("J", "!");// может использовать regular expressions
        System.out.println(string1);
        string1 = "JJD";
        System.out.println(string1.replaceFirst("J", "!"));// может использовать regular expressions

        System.out.println(string1.contains("D")); // ищет есть ли данный набор символов в строке. true / false

        string1 = "Java Python PHP";
        String[] strings = string1.split(" ");
        System.out.println(Arrays.toString(strings));

        // убрать пробелы trim / strip / stripLeading / stripTrailing
        System.out.println("\u3000");// "  " - длинный пробел
        System.out.println("\u0020");// " " - обычный пробел
        // trim - убирает пространство меньше или равно u0020
        // strip (J11) - убирает любое пространство
        // stripLeading (J11) - убирает любое пространство (начало строки)
        // stripTrailing (J11) - убирает любое пространство (конец строки)

        // printf - ОЧЕНЬ ресурсоёмкая!
        System.out.printf("строка '%s'\n", " qwe ".trim());
        System.out.printf("строка '%f'\n", 11.6);
        System.out.printf("строка '%d'\n", 566);


    }
}
