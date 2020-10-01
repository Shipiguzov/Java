package lesson2Tasks;

import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*Программа загадывает число в диапазоне [1;9]
        Пользователь вводит число с клавиатуры
        Программа в зависимости от введенного числа выводит в консоль следующее:
        "загаданное число больше"
        "загаданное число меньше"
        "Вы угадали" (программа завершает работу)
        если введен 0, выводит "выход из программы" (программа завершает работу) */
        byte number = (byte)(Math.random() * 8 + 1);
        //System.out.println(number); // проверка работы рандома
        byte userNumber;
        do {
            System.out.println("Угадай целочисленное число от 1 до 9 включительно");
            userNumber = scanner.nextByte();
            if (userNumber > 9 || userNumber < 1 ){
                System.out.println("Вы ввели не правильное число!!!");
                continue;
            }else if (userNumber == number){
                System.out.println("Бинго! Вы угадали число!");
            }else if (userNumber > number){
                System.out.println("Ваше число больше загаданного. Попробуйте ещё раз");
            }else if (userNumber < number){
                System.out.println("Ваше число меньше загаданного. Попробуйте ещё раз");
            }
        }while (userNumber != number);
    }
}
