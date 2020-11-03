package com.ifmo.jjd.lesson15.collection;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);

        // Коллекции используются для хранения наборов данных, различаются:
        // 1. безопасностью использования в многопоточных средах
        // в однопоточных приложениях использовать только коллекции для однопоточных процессов
        // 2. возможностью зранить дублирующиеся элементы
        // 3. возможностью хранить элементы в том порядке, в котором они были добавлены в коллекцию
        // 4. возможностью хранить элементы в отсортированном виде и т.п.

        // При хранении элементов в коллекциях, необходимо переопределить equals и hashcode

        // посмотреть методы интерфейсов для collection, list, set (смотреть инфу по 7 версии)

        System.out.println("----LinkedList----");
        // Особенности LinkedList:
        // 1. порядок элементов гарантирован
        // 2. можно хранить null
        // 3. допускает хранение дублирующихся элементов
        // Хранит объекты Node, которые содержат ссылки на соседние Node. Не хранит индексы, а считает

        // list будут доступны только методы, перечисленные в интерфейсе List
        List<Student> list = new LinkedList<>();
        // collection будут доступны только методы, перечисленные в интерфейсе Collection
        Collection<Student> collection = new LinkedList<>();
        LinkedList<Student> students = new LinkedList<>();
        // добавление элементов в конец списка
        students.add(student1);
        students.add(student2);
        students.add(student1);
        // добавление элемента на указанную позицию (смещает уже существующие элементы)
        students.add(1, student3);
        // обращение к несуществующему индексу:
        // java.lang.IndexOutOfBoundsException
        // students.add(90, student3);
        students.addFirst(null); // добавление в начало списка
        students.addLast(student2); // добавление в конец списка

        System.out.println(students);
        System.out.println(students.size()); // размер списка
        // получение элементов
        // java.lang.IndexOutOfBoundsException если элемент не найден
        System.out.println(students.get(0)); // возвращает ссылку на объект, который хранится в коллекции под индексом 0
        // java.utils.NoSuchElementException, если элемент не найден
        System.out.println(students.getFirst()); // первого
        // java.utils.NoSuchElementException, если элемент не найден
        System.out.println(students.getLast()); // последнего
        // удаление элементов
        students.removeFirst(); // удаление первого, возвращает ccылку на удаленный элемент
        students.removeLast(); // удаление последнего, возвращает ccылку на удаленный элемент

        // удаляет первой встреченной ссылки на элемент и возвращает true, если ссылки на объект нет, тогда false
        students.remove(student1);
        System.out.println("после удаления " + students);


        System.out.println("----ArrayList----");
        // в большинстве случаев отдается предпочтение ArrayList, а не LinkedList
        // Особенности ArrayList:
        // 1. реализован на основе массива
        // 2. можно хранить null
        // 3. допускает хранение дублирующихся элементов
        // 4. порядок гарантирован

        // по умолчанию создается массив на 10 элементов.
        // при выходе за длину массива, создается новая увеличенная копия массива
        ArrayList<Student> studentArrayList = new ArrayList<>();
        // можно сразу задать изначальную емкость
        studentArrayList = new ArrayList<>(30);
        System.out.println(studentArrayList.size()); // 0
        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(1, student1); // добавляет элемент, а не переприсваевает
        studentArrayList.add(null);
        System.out.println(studentArrayList.size()); // 4
        studentArrayList.trimToSize();
        System.out.println(studentArrayList.size()); // 4 (добавленный null останется)

        // получить часть списка, указав [начальную; конечную) позиции
        System.out.println("sublist: = " + studentArrayList.subList(1, 3)); // List

        // получение элементов по индексу
        System.out.println(studentArrayList.get(2));

        Student[] arr = {student1, student2};
        // удаление
        studentArrayList.remove(1); // ссылка на объект
        studentArrayList.remove(student1); // true / false
        studentArrayList.removeAll(Arrays.asList(arr));

        System.out.println("после удаления " + studentArrayList);

        // методы remove(Object o) использует метод equal()
        arr = new Student[] {student1, student2};
        studentArrayList.addAll(Arrays.asList(arr));


        // ArrayList из элементов LinkedList
        studentArrayList = new ArrayList<>(students);
        // LinkedList из элементов ArrayList
        students = new LinkedList<>(studentArrayList);

        System.out.println("----Set----");
        // Особенности Set:
        // 1. используется для хранения уникальных элементов
        // 2. обязательно дб переопределены методы equals и hashcode

        // Особенности HashSet:
        // 1. основан на hash таблице
        // 2. порядок хранения элементов может отличаться от порядка добавления
        // 3. можно хранить null (всегда будет на 1м месте)

        // Особенности LinkedHashSet:
        // 1. основан на hash таблице
        // 2. порядок хранения элементов не отличается от порядка добавления
        // 3. медленее, чем HashSet
        // 4. можно хранить null (всегда будет на 1м месте)

        // при создании из колеекции удалит все не уникальные объекты
        HashSet<Student> studentHashSet = new HashSet<>();
        studentHashSet = new HashSet<>(studentArrayList);
        studentHashSet.add(student1); // studentHashSet.addAll(students);
        studentHashSet.remove(student1); // studentHashSet.removeAll(students);
        // У Set'ов нету get

        System.out.println(studentHashSet);
        // Особенности TreeSet:
        // 1. хранит объекты в отсортированном порядке
        // 2. основан на алгоритме красно-чёрного дерева
        // 3. нельзя хранить null

        // для добавления элементов в TreeSet необходимо:
        // 1. чтобы класс (экземпляры которого будут храниться в сете)
        // реализовал интерфейс Comparable и его метод compareTo
        // 2. передать в конструктор TreeSet объект типа Comparator
        TreeSet<Student> studentTreeSet = new TreeSet<>();
        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        System.out.println(studentTreeSet);

        Comparator<Student> studentComparator = new NameComparator()
                .thenComparing(new AgeComparator());
        TreeSet<Student> studentTreeSet2 = new TreeSet<>(studentComparator);
        studentTreeSet2.add(student1);
        studentTreeSet2.add(student2);

        // перебор коллекции
        // в цикле foreach из коллекции удалять нельзя
        for (Student student : students) {
            System.out.println(student);
            student.setSurname("SURNAME");
            // students.remove(student); приведет к java.util.ConcurrentModificationException
        }
        // Collections.copy(); - посмотреть метод
        // iterator - ссылка на итератор коллекции students
        Iterator<Student> iterator = students.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAge() < 18) {
                iterator.remove();
            }
        }
    }
}
