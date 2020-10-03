package HomeWorks.lesson5Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        /*Найти количество вхождений одной строки в другую.
        Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза*/

        Scanner scanner = new Scanner(System.in);
        String word;
        System.out.println("Введите символы для поиска: ");
        word = scanner.nextLine();
        // System.out.println(word);
        String string;
        System.out.println("Введите слова через пробел, в которых будет осуществляться поиск слова " + word);
        string = scanner.nextLine();
        //Кот пёс котофей котэйро
        String[] listOfWords = string.split(" ");
        // System.out.println(Arrays.toString(listOfWords));
        int count = 0;
        for (String elem : listOfWords) {
            if (elem.contains(word)) count += 1;
        }
        System.out.println("Символы :" + word);
        System.out.print ("Содержаться в :" + string + "\n");
        System.out.println(count + " раз.");
    }
}
