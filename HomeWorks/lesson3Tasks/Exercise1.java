package lesson3Tasks;

import java.util.Arrays;

public class Exercise1 {
    public static void main(String[] args) {
        // Заполните массив на N элементов случайным целыми числами
        // и выведете максимальное, минимальное и среднее значение
        int[] array;
        int n = 5;
        int minRange = -100, maxRange = 100;
        // создание массива из случайных чисел
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            int var = (int)(Math.random() * (maxRange - minRange + 1) + minRange);
            array[i] = var;
        }
        // определение max, min и среднего значения массива
        int min = array[1];
        int max = array[1];
        int averange = 0;
        System.out.println(Arrays.toString(array));
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            averange += i;
            System.out.println(averange);
        }
        System.out.println("Наибольший элемент массива: " + max);
        System.out.println("Наименьший элемент массива: " + min);
        System.out.println("Среднее значение элементов массива: " + (double)averange / n);
    }
}
