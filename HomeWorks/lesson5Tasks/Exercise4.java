package HomeWorks.lesson5Tasks;

import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        /*Заменить все буквы в слове на строчные, а первую букву на заглавную
        Например, дано hello, получаем Hello / дано HeLLO, получаем Hello */
        Scanner input = new Scanner(System.in);
        String string4, newString5;
        char letterFirst;
        System.out.print("Введите слово: ");
        string4 = input.next();
        string4 = string4.toLowerCase();
        letterFirst = Character.toUpperCase(string4.charAt(0));
        newString5 = letterFirst + string4.substring(1);
        System.out.println(newString5);
    }
}
