package lesson3Tasks;

import java.util.Arrays;

public class Exercise2 {
    public static void main(String[] args) {
        //Создайте массив из чётных чисел [2;20] и
        // выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
        int[] array;
        array = new int[10];
        int number = 2;
        for (int i = 0; i < array.length ; i++) {
            array[i] = number;
            number += 2;
        }
        for (int i = array.length - 1; i >= 0 ; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
