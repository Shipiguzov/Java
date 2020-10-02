package HomeWorks.lesson3Tasks;

import java.util.Arrays;

public class DoubleArray1 {
    public static void main(String[] args) {
        /*Считает минимальное, максимальное и сумму элементов подмассивов духмерного массива*/
        int[][] doubleArrayOfNumbers;
        int min = -10, max = 10, width = 5, length = 10;
        int[][] arrayResult = new int[width][3];
        doubleArrayOfNumbers = new int[width][length];
        for (int i = 0; i < doubleArrayOfNumbers.length; i++) {
            for (int j = 0; j < doubleArrayOfNumbers[i].length; j++) {
                doubleArrayOfNumbers[i][j] = (int) (Math.random() * (max - min + 1)) + min;
            }
        }

        System.out.println(Arrays.deepToString(doubleArrayOfNumbers));
        for (int i = 0; i < doubleArrayOfNumbers.length; i++) {
            //System.out.println(Arrays.toString(i));
            int maxArray = doubleArrayOfNumbers[i][0];
            int minArray = doubleArrayOfNumbers[i][0];
            int sum = 0;
            for (int i1 : doubleArrayOfNumbers[i]) {
                if (i1 > maxArray) maxArray = i1;
                if (i1 < minArray) minArray = i1;
                sum += i1;
            }
            arrayResult[i][0] = minArray;
            arrayResult[i][1] = sum;
            arrayResult[i][2] = maxArray;
        }
        System.out.println(Arrays.deepToString(arrayResult));
    }
}
