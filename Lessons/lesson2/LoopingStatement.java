package lesson2;

import java.util.Scanner;

public class LoopingStatement {
    public static void main(String[] args) {
        // инкремент - увеличивает значение переменной на 1
        // постсуфиксный x++ (возвращает значение переменной, потом увелививает)
        // префиксный ++x (увеличивает значение, потом возвращает)
        // постсуфиксный x-- (возвращает значение переменной, потом уменьшает)
        // префиксный --x (уменьшает значение, потом возвращает)
        int a = 2;
        int res = a++ - ++a + a++ + a++ + a;
        System.out.println(res);
        // 2 - 4 + 4 + 5 + 6

        // циклы
        // цикл while
        /*
        while (условие) {
            инструкции в теле цикла;
        }
        условие - true/false
        */
        // вывести на экран числа из отрезка [55;78]
        int number = 55;
        while (number <= 78) {
            System.out.print(number++ + " ");
        }
        /*пользователь вводит с клавиатуры целое число
         * необходимо вывести число увеличенное на 2
         * цикл прерывает свою работу, если пользователь ввел 0*/

        Scanner scanner = new Scanner(System.in);
        //int num = scanner.nextInt();
        while (true) {
            System.out.println("Введите целочисленное число");
            int num = scanner.nextInt();
            if (num == 0) {
                System.out.println("Завершение программы");
                break;
            }
            System.out.println(num + 2);
        }

        /*do {
            инструкции в теле цикла
        } while (условие);
        сперва выполняется итерация цикла, затем проверяется условие*/
        int num2;
        do {
            System.out.println("Введите целочисленное число. Если хотите завершить работу, введите 0");
            num2 = scanner.nextInt();
            if (num2 != 0) {
                System.out.println(num2 + 2);
            } else {
                System.out.println("Выход из программы");
            }
        } while (num2 != 0);

        // цикл for для вызова fori
        // for (;;){
        //    } - бесконечный цикл
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        // Math.random() - double [0,1)
        // посмотреть как задавать диапазон
    }
}
