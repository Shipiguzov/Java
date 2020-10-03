package HomeWorks.lesson5Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        /*Написать функцию, которая проверяет, является ли строка палиндромом.
        Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево.
        Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/

        Scanner input = new Scanner(System.in);
        String word2, wordEdit;
        System.out.println("Введите слово: ");
        word2 = input.nextLine();
        wordEdit = word2.toLowerCase().replaceAll(" ", "");
        //System.out.println(wordEdit);
        boolean flag = true;
        for (int i = 0; i < wordEdit.length() / 2; i++) {
            /*System.out.println(i);
            System.out.println(wordEdit.charAt(i));
            System.out.println(wordEdit.charAt(wordEdit.length() - 1 - i));*/
            if (wordEdit.charAt(i) != wordEdit.charAt(wordEdit.length() - 1 - i)) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("Слово \"" + word2 + "\" является палиндромом");
        } else {
            System.out.println("Слово " + word2 + " не является палиндромом");
        }
    }
}
