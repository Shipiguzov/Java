package com.ifmo.jjd.lesson23;

import com.ifmo.jjd.lesson22.Course;

import com.ifmo.jjd.lesson22.Course;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
/*
             Stream API - набор методов для работы с данными, как с потоком.
             Позволяет представить различные наборы данных в виде потока,
             а далее: сортировать их, фильтровать, осуществлять поиск по различным критериям,
             кроме этого позволяет создавать новые потоки, создавать коллекции и мапы из потока данных и тд
         */
         /*
             Stream никогда НЕ ХРАНИТ ДАННЫЕ.
             Для сохранения данных из Stream нужно использовать специальные методы.
             Stream никогда НЕ ИЗМЕНЯЕТ ИСТОЧНИК (коллекцию, массив и тд), из которого он создан, все преобразования происходят только в потоках.
             В своей работе методы stream используют лямбда выражения.
         */

         /*
             Для работы с потоками данных необходимо:
             1. получить данные в виде потока - объект типа Stream
             2. выполнить промежуточные операции с потоком данных
             (промежуточные операции обрабатывают данные и возвращают Stream объект)
             3. выполнить терминальную (конечную) операцию
             (терминальная операция обрабатывает данные и завершает работу потока)
             Без терминальной операции промежуточные операции не начнут выполняться!!!
         */

        /*
             Например, получили объект stream, далее выполняем
             промежуточные операции (может быть несколько)
             stream.операция1() - вернет преобразованный объект stream
                   .операция2() - вернет преобразованный объект stream
                   .операция3()  - вернет преобразованный объект stream
                   .терминальнаяОперация(); // запускает промежуточные операции, данные обрабатываются, стрим закрывается
             основные терминальные операции: forEach / findFirst / findAny / xxxMatch / min / max / collect (может быть только одна)
             ставиться в конце списка промежуточных операций

             Если терминальной операции не будет, промежуточные выполнены не будут

         */

         /*
            Методы получения Stream объектов:
             * из коллекций collection.stream();
             * из массива Arrays.stream(arr);
             * из файла Files.lines(path_to_file);
             * из строки string.chars();
             * используя builder:
             * Stream.builder().add(obj1).add(obj2).add(objN).build();
             * Stream.of(1, 4, 7); любой набор данных
         */

         /*
         Распространенные промежуточные операции:
             * filter принимает на вход Predicate, возвращает поток (Stream) с теми объектами, которые удовлетворяют условию
             * map принимает на вход Function, возвращает новый поток (Stream), состоящий из обработанных функцией объектов
             исходного Stream
             * limit принимает на вход int, возвращает новый поток (Stream), состоящий из указанного количества первых объектов
             * skip принимает на вход int, убирает из потока указанной количество первых элементов,
             возвращает новый поток (Stream), состоящий из оставшихся элементов (или пустой Stream)
             * distinct возвращает поток (Stream), состоящий из уникальных объектов
             * sorted возвращает поток (Stream) отсортированных объектов, можно передать компаратор
             * peek принимает на вход Consumer, обрабатывает каждый элемент потока (Stream), возвращает новый поток (Stream)
         */
        /*
        Распространенные терминальные операции:
             * forEach принимает на вход Consumer, применяет переданный метод к каждому объекту потока (Stream),
             порядок Обработки при параллельном выполнении не гарантируется
             * anyMatch принимает на вход Predicate, возвращает true,  если хотя бы один элемент потока соответствует условию
             * allMatch принимает на вход Predicate, возвращает true,  если все элементы потока соответствуют условию
             * noneMatch принимает на вход Predicate, возвращает true,  если ни один элемент потока соответствует условию
             * findFirst возвращает первый элемент потока в Optional контейнере
             * findAny возвращает случайный элемент потока в Optional контейнере
             * min | max принимают на вход компаратор, возвращают минимальный / максимальный элемент потока в Optional контейнере
             * collect принимает на вход Collector, возвращает коллекцию или мапу
         */

        Stream<Integer> integerStream = Stream.of(-8, -312, 0, -7, 12321, 1, -1, 0, 1, 32135, 1, 1000);
        // filter - принимает на вход придекат. Если придекат false - элемент удаляется из потока, если true - остается
        integerStream.filter(num -> num < 0) // в stream остануться только отрицательные элементы
                .map((num) -> num * num) // создаст новый stream с преобразованными элементами, полученный от предыдущего stream {-8 * -8, -312 * -312, -785 * -785 ...}. может поменять тип данных, т.к. принимает на вход Function
                .limit(3) // создаст новый stream с первыми 3 элементами предыдущего stream
                .forEach(System.out::println); // принимает значение и закрывает stream. может принять ссылку на метод, который будет выполняться ко всем объектам stream

        integerStream = Stream.of(-6, 0, 0, 81, -6, 1, 0, -6, 7, -6);
        integerStream.distinct() // возвращает новый stream с уникальными элементами предыдущего stream
                .sorted() // сортирует в натуральном порядке (от меньшего к большему). Может принимать объект типа Comparator
                .forEach(System.out::println);
        // anyMatch - хотя бы один| allMatch - каждый | noneMatch - ни один - принимает на вход Predicate, возвращает true / false
        integerStream = Stream.of(-6, 0, 0, 81, -6, 1, 0, -6, 7, -6);
        System.out.println(integerStream.anyMatch(num -> num == 0)); // логическое || (до первого true)
        integerStream = Stream.of(-6, 0, 0, 81, -6, 1, 0, -6, 7, -6);
        System.out.println(integerStream.allMatch(num -> num > 300)); // логическое && (до первого true)
        integerStream = Stream.of(-6, 0, 0, 81, -6, 1, 0, -6, 7, -6);
        System.out.println(integerStream.noneMatch(num -> num > 1000)); // до первого true

        // findFirst - вернёт первый элемент в Optional контейнере
        // findAny - вернёт произвольный элемент в Optional контейнере
        // Optional - null safe container, J8
        String[] colors = {"white", "red", "black", "green", "yellow", "brown"};
        String firstColor = Arrays.stream(colors)
                //.skip(1) // создает новый поток. Пропускает указанное количество элементов, а оставшиеся добавляет в новый поток
                .filter(color -> color.startsWith("b"))
                .findFirst().get(); // Optional -> String. Если будет результат null - тогда будет exeption
        //.findFirst().orElse("default"); // Optional -> String. Если будет результат null - тогда будет "default"
        System.out.println(firstColor);

        boolean isPresent = Arrays.stream(colors).findFirst().isPresent(); // если null - false, если есть значение - true

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        System.out.println(courses);

        // min | max - терминальные. Возвращают Optional

        Course minByPrice = courses.stream() // поток из элементов коллекции
                .min(Comparator.comparing(Course::getPrice)).orElse(courses.stream().findAny().get());
        System.out.println(minByPrice);

        // максимальный по продолжительности
        Course maxByDuration = courses.stream()
                .min(Comparator.comparing(Course::getDuration).reversed()).orElse(courses.stream().findAny().get());
//              .max(Comparator.comparing(Course::getDuration)).orElse(courses.stream().findAny().get())
        System.out.println(maxByDuration);

        // Получим массив курсов дороже 20000
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                .toArray(Course[]::new); // получим массив из объектов типа Object.
        // Если хотим определенного типа, то надо передать ссылку на конструктор массива Course[]

        System.out.println(Arrays.toString(coursesArr));

        // Увеличим стоимость курсов продолжительностью < 3 на 5000. Получим List
        List<Course> coursesList = courses.stream()
                .filter(course -> course.getDuration() < 3)
                .peek(course -> course.setPrice(course.getPrice() + 5000)) // в отличии от map не создает новые объекты в потоке, а изменяет своиства объектов в существующем потоке
                .collect(Collectors.toList()); // Collectors.toSet

        ArrayList<Course> courseArrayList = courses.stream()
                .distinct()
                .sorted(Comparator.comparing(Course::getName))
                .collect(Collectors.toCollection(ArrayList::new)); // ссылка на конструктор любой коллекции
        System.out.println("!!!" + coursesList);

        // Получим мапу
        colors = new String[]{"red", "white", "blue", "black", "green", "red"};
        Map<String, Integer> mapFromArr = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        Function.identity(),// Function elem -> elem ключи
                        String::length,// Funcrion s -> s.length() значения
                        Integer::sum// BinaryOperator(val1, val2) -> val1 + val2 что делать, если ключи одинаковые
                ));
        System.out.println(mapFromArr);

        // flatMap | map
        String[][] strings = {
                {"10", "-7", "122", "10"},
                {"12", "122", "65", "122"},
                {"67", "-1", "200", "3"}
        };
        String[][] stringsMap = Arrays.stream(strings)
                .map(arr -> Arrays.stream(arr).distinct().sorted().toArray(String[]::new))
                .toArray(String[][]::new);

        String[] stringsFlatMap = Arrays.stream(strings)
                .flatMap(arr -> Arrays.stream(arr).distinct().sorted()) // сглаженный вывод
                .toArray(String[]::new);

        System.out.println(Arrays.deepToString(stringsMap));
        System.out.println(Arrays.toString(stringsFlatMap));

        // Вставка про паттерн Observer (далее)
        integerStream = Stream.of(-6, 0, 0, 81, -6, 1, 0, -6, 7, -6);
        /*integerStream.forEach(integer -> System.out.println(100 / integer));
        integerStream.forEach(integer -> {
            try {
                System.out.println(100 / integer);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
        });*/
        integerStream.forEach(wrapper(integer -> System.out.println("div " + 100 / integer)));
        integerStream.forEach(wrapper(integer -> {
            try {
                someVoid(integer);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }));
    }

    private static void someVoid(int num) throws IOException {}

    private static Consumer<Integer> wrapper(Consumer<Integer> consumer) {
        return integer -> {
            try {
                consumer.accept(integer);
            } catch (ArithmeticException e) {
                //System.out.println("ArithmeticException");
                e.printStackTrace();
            }
        };
    }
}
