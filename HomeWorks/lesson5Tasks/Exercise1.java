package HomeWorks.lesson5Tasks;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        /*Задать массив на N слов.
        В цикле считывать с консоли слова (scanner.nextLine()), и добавлять их в массив
        (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль */
        int N = 5;
        int i = 0;
        String inputWord;
        String[] wordsArray = new String[N];
        Scanner input = new Scanner(System.in);

        Arrays.fill(wordsArray, "");
        do {
            boolean flag1 = true;
            System.out.println("Введите слово (для выхода - введите exit): ");
            inputWord = input.nextLine();
            inputWord = inputWord.toLowerCase();
            if (inputWord.equals("exit")) {
                break;
            }
            for (int j = 0; j < i; j++) {
                if (wordsArray[j].equals(inputWord)) {
                    flag1 = false;
                    break;
                }
            }
            if (flag1) {
                wordsArray[i] += inputWord;
                i++;
            }
        } while (i < wordsArray.length);
        System.out.println(Arrays.toString(wordsArray));
    }
}
