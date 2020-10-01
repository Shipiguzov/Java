package lesson1;

public class Lesson1Test {
    public static void main(String[] args) {
        int intVar1 = 8, intVar2 = 3, intVar3;
        boolean booleanVar;
        intVar3 = intVar1 % intVar2;
        booleanVar = (intVar3 == 0) ? true : false;
        System.out.println(intVar1--);
        System.out.println(intVar1);
        System.out.println(booleanVar);
        intVar1 %= 3;
        System.out.println(intVar1);
    }
}
