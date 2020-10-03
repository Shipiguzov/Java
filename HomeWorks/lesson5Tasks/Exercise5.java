package HomeWorks.lesson5Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        /*Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины
        Например, в "в предложении все слова разной длины" самое длинное слово "предложении" */
        Scanner input = new Scanner(System.in);
        System.out.println("Введите предложение: ");
        String string5 = input.nextLine();
        String[] words5 = string5.split(" ");
        //System.out.println(Arrays.toString(words5));
        String maxWord = words5[0];
        for (String s : words5) {
            if (maxWord.length() < s.length()) maxWord = s;
        }
        System.out.println("Самое длинное слово в веденном предложении: " + maxWord);
    }
}
