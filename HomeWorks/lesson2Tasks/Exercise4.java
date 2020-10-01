package lesson2Tasks;

public class Exercise4 {
    public static void main(String[] args) {
        /*Написать код, который будет проверять попало ли случайно сгенерированное
        целое число из отрезка [10;500] в интервал (25;200) и выводить результат в консоль.
        Примеры работы программы:
        Число 345 не содержится в интервале (25;200)
        Число 110 содержится в интервале (25;200)*/
        short numberMin = 10;
        short numberMax = 500;
        short number = (short)(Math.random() * (numberMax - numberMin + 1) + numberMin);
        if (number > 25 && number < 200) {
            System.out.println("Число " + number + " содержится в интервале (25;200)");
        } else {
            System.out.println("Число " + number + " не содержится в интервале (25;200)");
        }

    }
}
