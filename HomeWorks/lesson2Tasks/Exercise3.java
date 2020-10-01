package lesson2Tasks;

public class Exercise3 {
    public static void main(String[] args) {
        /*Создайте программу, выводящую на экран все
        неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….*/
        for (byte count = 90; count >= 0 ; count -= 5) {
            System.out.print(count + " ");
        }
    }
}
