package lesson3;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class ArrayLesson {
    public static void main(String[] args) {
        // массивы предназначены ля хранения данных
        // элементы в массиве одного типа данных
        // длина массива задается при его создании
        // длину массива изменить нельзя
        // массивы - ссылочный тип данных, является объектом
        // элементы массива храняться под индексами, начиная с 0

        // объявление переменной массива: тип_данных[] имя_переменной

        int[] ints1;
        // int ints1[] - не предпочтительный способ задания массива

        // создание массива
        // new int[длина_массива];
        ints1 = new int[5];
        // создан массив на 5 элементов типа int и заполнен значениями по умолчанию
        // целые числа : 0
        // числа с плавающей точкой : 0.0
        // boolean : false
        // char : '\u0000 ()
        // ссылочные типы : null
        int[] ints2 = {45, 90, 12, -88, 54, 8, -221};

        // ints2 = {45, 90, 12, -88, 54, 8, -221} - нельзя
        ints2 = new int[]{45, 12, 8, -221};

        // доступ к элементам массива осуществляется  по индексуЖ:
        // имя_массива[индекс]
        // индекс - тип int
        int ints2Elem = ints2[3]; // получили элемент из массива ints2 с индексом 3 (-221)
        ints2[1] = 4147; // обращение к несуществующему элементу массива приведет
        // к ошибке java.lang.ArrayIndexOutOfBoundsException

        // длина массива
        System.out.println(ints2.length); // тип int = 4

        // вывод в консоль
        System.out.println(Arrays.toString(ints1));
        System.out.println(Arrays.toString(ints2));

        //перебор элементов массива
        ints2 = new int[]{60, -80, 0, 200, 44};

        // iter + Enter - перебирает все элементы массива.
        // На каждой итерации переменной копируется значение элемента массива
        // в данном цикле элемент массива изменять не можем
        for (int elem : ints2) {
            System.out.println("elem " + elem);
            // elem *= 2; нельзя изменить значение элементов массива
        }
        System.out.println(Arrays.toString(ints2));

        for (int i = 0; i < ints2.length; i++) {
            System.out.println("ints2[i] = " + ints2[i]);
            ints2[i] = 90;
        }
        System.out.println(Arrays.toString(ints2));

        //сравнение массивов
        ints1 = new int[]{60, -80, 0, 200, 44};
        ints2 = new int[]{60, -80, 0, 200, 44};
        System.out.println(Arrays.equals(ints1, ints2));
        // возвращает true/false

        // compare , compareUnsigned, mismatch - посмотреть в документации

        // сортировка массива
        Arrays.sort(ints1); // Arrays.sort(ints1, [from, to));
        Arrays.parallelSort(ints2); // работает намного быстрее с большими массивами (примерно больше 10000), с маленькими - намного хуже и не точно

        // поиск в отсортированном массиве
        ints1 = new int[]{-90, -10, 0, 12, 45, 1231};
        System.out.println(Arrays.binarySearch(ints1, -10)); // 1
        System.out.println(Arrays.binarySearch(ints1, 89)); // -6
        System.out.println(Arrays.binarySearch(ints1, -91)); // -1
        // возвращает индекс указанного массива указанного элемента

        //копирование массивов
        // 1 вариант
        int [] newInt = ints1; // создает ещё одну ссылку в области памяти массива ints1
        int[] clone = ints1.clone(); // создает полную копию массива и возвращает её
        // 2 вариант
        // System.arraycopy(
        // из_какого_массива, с_какого_индекса
        // );
        ints1 = new int[]{60, -80, 0, 200, 44, 90, 111};
        int[] newInts = new int[15];
        System.arraycopy(ints1, 2, newInts, 4, 3);
        System.out.println(Arrays.toString(newInts));

        // 3 вариант Array.copyOf()
        int[] copyInts = Arrays.copyOf(ints1, 3);
        System.out.println(Arrays.toString(copyInts));

        int[][] ints3 = new int[3][4];
        // [[0, 0, 0, 0], [0, 0, 0, 0], [0, 0, 0, 0]]
        System.out.println(Arrays.deepToString(ints3));

        int[][] ints4 = new int[3][];
        // [null, null, null]
        ints4[0] = new int[1];
        ints4[1] = new int[2];
        ints4[2] = new int[3];
        // [[0], [0, 0], [0, 0, 0]]

        int[][] ints5 = {
                {2, 3, 45},
                {6, 7, 81, 8},
                {16, -7, 801, 228}
        };

        for (int i = 0; i < ints5.length; i++) {
            for (int j = 0; j < ints5[i].length; j++) {
                ints5[i][j] *= ints5[i][j];
            }
        }
        System.out.println(Arrays.deepToString(ints5));


        /*Git
        * при установке надо выполнить git config
        * там указываем --global // только для текущего юзера
        * user.name "имя_подписи"
        * user.email email
        *
        * создает копию репозитория с ссылки github в текущей папке. По умолчанию имя папки будет соответствовать
        * имени репозитория. Можно указать другое имя:
        * git clone ссылка_с_gitHub имя_папки
        *
        * Синхронизировать репозиторий в текущий папке на локальной машине с gitHub
        * git pull
        *
        * git init
        *
        * git status
        *
        * git add имя_файла
        *
        * игнорируем папку .idea , out и файлы *.iml
        * игнорируются папки и файлы из файла .gitignore (указываются в столбик)
        *
        * git commit -m "комментарий"
        *
        * связывает репозиторий локальный с удаленным (один раз делается)
        * git remote add origin "ссылка_на_репозторий"
        *
        * git push -u origin master
        *
        * */
    }
}
