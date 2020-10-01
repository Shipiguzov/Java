package lesson2Tasks;

public class Exercise2 {
    public static void main(String[] args) {
        /*Создайте программу, выводящую на экран первые
        20 элементов последовательности 2 4 8 16 32 64 128*/
        for (short count = 1; count < 20 ; count++) {
            System.out.print((int)Math.pow(2, count) + " ");
        }
    }
}
