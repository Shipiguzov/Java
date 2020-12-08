package com.ifmo.jjd.patterns.chain;

public class Chain {

    public static void main(String[] args) {

        IHandler handler = getHandlerChain();

        handler.handleRequest("данные уйдут в файл", Priority.MIDDLE);

        handler.handleRequest("данные уйдут в DB", Priority.URGENT);

        handler.handleRequest("данные2 уйдут в файл", Priority.HIGH);

        handler.handleRequest("данные уйдут в консоль", Priority.LOW);
    }

    private static IHandler getHandlerChain(){
        IHandler first = new ConsoleHandler(Priority.LOW);
        IHandler nex1 = first.setNext(new FileHandler(Priority.MIDDLE, Priority.HIGH));
        IHandler nex2 = nex1.setNext(new DBHandler(Priority.URGENT));
        return first;
    }
}

// данные/запрос
// обработчик1
// обработчик2
// обработчик3 *
// обработчик4
// обработчик1->обработчик2->обработчик3->обработчик4
// обработчик.обработкаЗапроса(данные/запрос)

// должен быть абстрактный класс, который является родительским для всех обработчиков и имплементирует общеий интерфейс
// каждый обработчик должен наследоваться от этого класса и Owerride метод обработки данных/запроса
