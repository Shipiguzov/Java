package lesson2Tasks;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        /*Задача на синтаксис switch. Дана целочисленная переменная (номер билета от пользователя):
        если ее значение 111, 222 или 333 сообщить пользователю, что он получит "Книгу",
        если ее значение 444 или 555 сообщить пользователю, что он получит "Телефон",
        если ее значение 777 сообщить пользователю, что он получит "Ноутбук".
        В остальных случаях сообщить, что приза нет.*/
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ввыдите номер билета");
        int ticket = scaner.nextInt();
        switch (ticket) {
            case 111:
            case 222:
            case 333:
                System.out.println("Поздравляем! Вы выиграли книгу");
                break;
            case 444:
            case 555:
                System.out.println("Поздравляем! Вы выиграли телефон");
                break;
            case 777:
                System.out.println("Поздравляем! Вы выиграли ноутбук");
                break;
            default:
                System.out.println("Сожалем, но для вас приза нету. Возможно повезёт в другой раз :(");
        }
    }
}
