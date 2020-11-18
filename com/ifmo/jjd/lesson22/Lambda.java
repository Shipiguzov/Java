package com.ifmo.jjd.lesson22;

public class Lambda {
    public static void main(String[] args) {
        // лямбда - реализация абстрактного метода интерфейса. При вызове получаем объект такого же типа, что и этот интерфейс
        // Функциональный интерфейс - интерфейс, у которого только один абстрактный метод, количество дефолтных методов не имеет значение

        Operation sum = (a, b) -> a + b; // Double::sum
        //sum = Calculator::getSum; // попытка вызвать нестатический метод из статического контекста (getSum - не статический) - ошибка
        //Double.sum(3, 5); // вызов метода
        //sum = Double::sum; // ссылка на метод (имя_класса::имя_метода) (аргументы беруться у метода, на который дана ссылка)
        // Operation sum = (аргументы) -> тело метода;
        /*
            Синтаксис лямбда:
            Принимаемые аргументы ():
                1. Можно не заключать в (), если аргумент один
                2. Колиечство аргументов лямбда должно быть таким же, сколько указано в абстрактном методе
                3. В остальных случаях () обязательны (если больше одного аргументов, или аргументов 0)
                4. Можно не указывать тип данных аргументов, т.к. они указаны в методе интерфейса (беруться оттуда).
                    Если generic, тогда тип данных указываем при объявлении (Operation<Double> sum = (a, b) -> a + b;)

            Тело метода (реализация метода):
                1. Если реализация метода состоит из одной инструкции, то тело метода не заключается в {}, return по умолчанию.
                2. Если реализация метода состоит из нескольких инструкций, то тело метода необходимо заключить в {}.
                    return необходимо указывать явно.

             () -> {
                инструкция1;
                инструкция2;
                return результат
             }
        * */
        System.out.println(Calculator.calculate(56, 78, sum));
        System.out.println(sum.execute(2, 3));

        System.out.println(Calculator.calculate(4, 7, (a , b) -> a - b));

        Operation div = (first, second) -> {
            if (second == 0) throw new IllegalArgumentException("second must be not zero");
            return first / second;
        };
        System.out.println(Calculator.calculate(56, 78, div));
        System.out.println(div.execute(2, 3));

        EditAble toUpperCase = text -> text.toUpperCase();
        EditAble toLowerCase = (txt) -> txt.toLowerCase();
        System.out.println(toUpperCase.edit("test"));
        System.out.println(toLowerCase.edit("TeXt"));

        System.out.println();

        // Из-за того, что дефолтные методы возвращают тип данных самого интерфейса, можно использовать другие дэфолтные
        // метода или абстрактный метод функционального интерфейса
        EditAble doubleText = text -> text + text;
        // сначала вызываем необходимые дэфолтные метода, потом основной
        System.out.println(doubleText
                .addPrefix("((") // вернёт объект типа EditAble
                .addPostfix("))") // // вернёт объект типа EditAble
                .edit("ДАННЫЕ")); // вернёт объект типа String
    }
}

@FunctionalInterface // если 2 метода и более при этой аннотации - будет ошибка компиляции. Не делает интерфейс функциональным
interface Operation{ // функциональный интерфейс с одним абстрактным методом execute
    double execute(double a, double b);
}

@FunctionalInterface
interface EditAble {
    String edit(String text);

    // дэфолтные методы возвращают тип интерфейса. Являются вспомогательным функционалом
    default EditAble addPrefix(String prefix) {
        System.out.println("Add prefix");
        return text -> edit(prefix + " " + text);
    }

    default EditAble addPostfix(String postFix) {
        System.out.println("Add postfix");
        return text -> edit(text + " " + postFix);
    }
}

class Calculator{
    public double getSum (double a, double b) {
        return a + b;
    }
    public static double calculate(double a, double b, Operation operation){
        return operation.execute(a, b);
    }
}