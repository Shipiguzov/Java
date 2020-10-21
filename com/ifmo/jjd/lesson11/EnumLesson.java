package com.ifmo.jjd.lesson11;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;

public class EnumLesson {
    public static void main(String[] args) {
        Article article = new Article("Путешествие в Австралию");
        article.setText("Text");
        // обращение к элементу перечисления: ИмяПеречисления.ЭЛЕМЕНТ
        article.setCountry(Country.AUSTRALIA);

        Article uk = new Article("Путешествие в Британию");
        uk.setText("Text");
        uk.setCountry(Country.UK);

        // методы enum
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        // индекс элемента в массиве перечисления
        System.out.println(Country.AUSTRALIA.ordinal());

        for (Country country : countries) {
            System.out.println("country: " + country);
        }

        // получение элемента перечисления по строке
        // метод чувствителен к регистру
        // метод выбросит исключение, если элемент не будет найден
        Country byString = Country.valueOf("USA"); // Country.USA

        String countryName = Country.AUSTRALIA.toString();
        countryName = Country.AUSTRALIA.name();
        System.out.println(countryName);

        int highCode = Priority.HIGH.getCode();
        System.out.println(highCode);
        Priority.LOW.setCode(12);
        System.out.println(Priority.LOW.getCode());

        System.out.println(Priority.MIDDLE.getCode());

        // enum Operation
        System.out.println(Operation.MULTI.action(34, 78));
        System.out.println(Operation.SUM.action(34, 78));

        // обращение к enum, которые объявлены внутри класса
        // ИмяКласса.ИмяПеречисления.ЭЛЕМЕНТ
        System.out.println(SomeClass.EnumInClass.THREE);
    }
}

// Если перечисление используется несколькими классами в программе, то правильно вынести его в отдельный класс
// с модификатором public (например, enum Month)
class SomeClass {

    private EnumInClass enumInClass;

    public SomeClass(EnumInClass enumInClass) {
        this.enumInClass = enumInClass;
    }

    // private - не позволит обратиться к EnumInClass вне класса
    // default - сможем обратиться к EnumInClass внутри пакета
    // protected - сможем обратиться к EnumInClass из дочерних классов
    // public - сможем обратиться к EnumInClass из любого участка программы
    public enum EnumInClass {
        ONE, TWO, THREE
    }
}

// enum перечисление - набор логически связанных констант
// объявление перечислений enum ИмяПеречисления {
//      элементы перечисления через запятую
//      если в enum только элементы перечисления, то после последнего точку с запятой можно опустить
// }
// перечисления - константы
enum Country {
    UK, USA, AUSTRALIA, GREAT_EMPIRE // объекты типа Country
}

enum Priority {
    HIGH(100), MIDDLE(50), LOW(0); // инициализация конструктора описанного ниже

    private int code;

    // можно добавить конструкторы и любые методы. Конструкторов может быть сколько угодно (быть переопределены)
    Priority(int code) {
        this.code = code;
    }

    //метод доступен всем элементам перечисления Priority
    public int getCode() {
        return code;
    }

    //метод доступен всем элементам перечисления Priority
    public void setCode(int code) {
        this.code = code;
    }

}

enum Operation {
    SUM {
        @Override
        int action(int a, int b) {
            return a + b;
        }
    }, MULTI {
        @Override
        int action(int a, int b) {
            return a * b;
        }
    };

    abstract int action(int a, int b);

    /*public int action(int a, int b) {
        if (this.equals(SUM)) {
            return a + b;
        } else if (this == MULTI) {
            return a * b;
        }
        return 0;
    }*/
}
