package com.ifmo.jjd.lesson6;

// имя public класса должно соответствовать имени файла
// в файле может быть только однин public класс
// название
// количество картинок
// автор (имя, фамилия)`
public class ColouringBook {
    // свойства / поля / атрибуты
    private String title; // название, значение по умолчанию null
    private int pageCount; // название, значение по умолчанию 0
    private Author author; // автор, значение по умолчанию null
    // значение свойств по умолчанию:
    // boolean: false
    // целочисленные типы: 0
    // числа с плавающей точной: 0.0
    // char: u0000
    // ссылочные типы данных: null

    // модификаторы доступа:
    // private - доступны только в рамках класса
    // public - доступны из любого участка программы
    // package-private / delault (если не установлен) - доступны в рамках пакета
    // protected - доступны в рамках пакета + в рамках дочерних классов
    // рамки класса - между { и } класса

    // сеттер - метод, которые позволит выполнить проверку входящих данных и установить значение свойства объекта
    // (если проверки пройдены)

    // public - модификатор доступа
    // void - метод ничего не возвращает, а просто выполняет действие (System.out.println("Строка"))
    // setTitle - имя метода должно отражать то, что происходит в методе
    // (String title) - аргументы метода, принимает на вход объект типа String
    public void setTitle(String title) {
        // null len > 3
        if (title == null || title.length() < 3) {
            throw new IllegalArgumentException("title must be 3 or more");
        }
            // присваеваем значение свойства title равное (String title)
            // this - ссылка на текущий объект
            // текущий объект - объект, у которого вызывается метод (dogs, fowers)
            // (this можно не использовать, если имя аргумента отличается от название свойства)
            this.title = title;
    }
    // геттер - метод, который возвращает значение свойства
    // public - модификатор доступа
    // String - тип возвращаемого значения
    // getTitle - названиие метода
    // () - без аргументов
    public String getTitle(){
        // return - завершает работу метода
        //          возвращает результат работы метода
        return title;
    }

    // alt + Insert / ПК -> generate

    public void setPageCount(int pageCount) {
        if (pageCount < 5)
            throw new IllegalArgumentException("pageCount must be 5 or more");
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setAuthor(Author author) {
        if (author == null)
            throw new IllegalArgumentException("author не должен быть null");
        this.author = author;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ColouringBook{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}

/* класс {
        свойства
        конструкторы
        геттеры + сеттеры
        методы класса
        переопределённые методы
}
*/