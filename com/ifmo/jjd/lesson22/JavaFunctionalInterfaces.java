package com.ifmo.jjd.lesson22;


import java.util.function.Function;
import java.util.function.Predicate;

public class JavaFunctionalInterfaces {
    public static void main(String[] args) {
        /*
        В Java есть определённый набор готовых функциональных интерфейсов
            ! Predicate<T>: boolean test(T t); для проверки на соответствие условию
            Predicate or(Predicate), Predicate and(Predicate), Predicate negative(Predicate) - дэфолтные методы Predicate
            ! Function<T, R>: R apply(T t);  T и R могут быть одинаковыми типами данных.R и T - любые типы данных (колекция и мапа и т.п.)
            ! UnaryOperation<T>: T apply(T t);
            BiFunction<T, U, R>: R aplly (T t, U u);
            ! BinaryOperator<T>: T apply(T t, T t);
            ! Consumer<T>: void accept(T t);
            ! - пописать реализации самому
        */

        Predicate<Integer> isEven = integer -> integer % 2 == 0;
        Predicate<Integer> isPositive = integer -> integer > 0;
        System.out.println(isEven.test(78));

        // положительное и чётное
        System.out.println(isPositive.and(isEven).test(78)); // &&
        System.out.println(isPositive.or(isEven).test(78)); // ||

        Function<Integer, Integer> s = x -> x * x;
        Function<Integer, Integer> add = x -> x * 2;
        // compose(before) - действие, переданное в метод, выполняется до основного
        // andThen(after) - действие, переданное в метод, выполняется после основного
        int result = add    // 3
                .compose(s) // 1
                .andThen(s) // 4
                .compose(s) // 2
                .apply(3);
    }
}
