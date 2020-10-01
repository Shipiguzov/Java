package lesson3Tasks;

import java.util.Arrays;

public class Sorting {
    // Сортировка одномерного целочисленного массива методом выбором
    //
    public static void main(String[] args) {
        int[] arrayOfNumbers;
        int arrayLength = 10;
        int min = -10, max = 10, differance = max - min;
        arrayOfNumbers = new int[arrayLength];
        int count = 0;
        for (int i = 0; i < arrayOfNumbers.length; i++) {
            arrayOfNumbers[i] = (int)(Math.random() * (differance + 1)) + min;
        }
        System.out.println(Arrays.toString(arrayOfNumbers));
        for (int i = arrayOfNumbers.length - 1; i >= 0 ; i--) {
            for (int j = arrayOfNumbers.length - 1; j > i; j--) {
                if (arrayOfNumbers[j] < arrayOfNumbers[i]) {
                    int temp;
                    temp = arrayOfNumbers[i];
                    arrayOfNumbers[i] = arrayOfNumbers[j];
                    arrayOfNumbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arrayOfNumbers));
    }
}
