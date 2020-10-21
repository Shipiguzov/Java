package com.ifmo.jjd.lesson7.lecture;

// extends - наследование (множественное наследование запрещено)
// Класс BattleUnit наследует от класса Unit
// Класс BattleUnit - дочерний класс
// Класс Unit - родительский класс
// Дочерний класс получает доступ ко всем доступным свойствам и методам родительского класса

abstract public class BattleUnit
        extends Unit
        implements AttackAble{

    protected int attakPoints;

    // Если в родительском классе отсутствует конструктор по умолчанию, мы обязаны исользовать конструктор родительский
    // в конструкторе родительского. Данные должны быть переданы в родительсикй конструктор, каким образом - не важно
    // super - так же как this. только для конструктора
    public BattleUnit(int healthPoints, int agilityPoints, int attakPoints) {
        super(healthPoints, agilityPoints);
        if (attakPoints <= 0) throw new IllegalArgumentException("attakPoints <= 0");
        this.attakPoints = attakPoints;
    }

    // Класс BattleUnit реализует (имплементиует) интерфейс RestAble и AttackAble, в которых есть методы run с реализацией
    // В такой ситуации мы обязаны явно указать, какой метод выбрать
    @Override
    public void run() {
        System.out.println("Резизация run BattleUnit");
    }
}
