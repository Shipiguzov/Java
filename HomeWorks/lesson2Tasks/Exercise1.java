package lesson2Tasks;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        /*Пользователь! загадывает число в диапазоне от [1 до 100], программа пытается его угадать
        (используйте метод бинарного поиска - деление отрезка на 2).
        Программа может задавать пользователю вопросы: Число равно X? / Число больше X? / Число меньше X? и в зависимоти от ответа пользователя принимать решения.
        PS: вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от 1 до 100 включительно:");
        byte numberUser = scanner.nextByte();
        //System.out.println(number);
        int number = 50;
        int change;
        boolean condition = true;
        if (numberUser == 100) {
            System.out.println("Загаданное вами число 100");
        } else {
            int numberPrev = 100;
            while (condition) {
                if (numberUser == number) {
                    System.out.println("Загаданное вами число " + number);
                    condition = false;
                } else {
                    System.out.println("Загаданное вами число больше " + number + "? (0 - нет, 1 - да)");
                    byte anwser = scanner.nextByte();
                    if ((numberPrev - number) % 2 == 0) {
                        change = (numberPrev - number) / 2;
                    } else {
                        change = Math.abs(numberPrev - number) / 2 + 1;
                    }
                    //System.out.println(number + " " + numberPrev + " " + change);
                    numberPrev = number;
                    switch (anwser) {
                        case 0 :
                            number = number - Math.abs(change);
                            break;
                        case 1 :
                            number = numberPrev + change;
                            break;
                    }
                }
            }
        }
    }
}
