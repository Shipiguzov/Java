package lesson3Tasks;

import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        /*Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
        Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.
        Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.*/
        int arrayLength = 11;
        int[] array;
        int min = -1, max = 1;
        int[] result = {0, 0, 0};
        array = new int[arrayLength];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)((int)(Math.random() * (max - min + 1)) + min);
            switch (array[i]) {
                case -1:
                    result[0]++;
                    break;
                case 0:
                    result[1]++;
                    break;
                case 1:
                    result[2]++;
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(result));
        if (result[0] > result[1] && result[0] > result[2]) {
            System.out.println("Элемнт массива -1 встречается чаще всего");
        } else if (result[1] > result[2]) {
            System.out.println("Элемнт массива 0 встречается чаще всего");
        } else if (result[2] > result[1]) {
            System.out.println("Элемнт массива 1 встречается чаще всего");
        } //else {
            //System.out.println("Есть элементы, которые встречаются одинаковое количество раз");
        //}
    }
}
