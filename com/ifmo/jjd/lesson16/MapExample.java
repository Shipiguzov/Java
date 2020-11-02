package com.ifmo.jjd.lesson16;

import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        // Мапы хранят данные в парах ключ - значение
        // Особенности map:
        // 1. Ключи мапы должны быть уникальны.
        // 2. Каждому ключу соответствует только одно значение.
        // 3. Мапы не являются коллекциями.

        // самые популярные: HashMap<K, V> и Treemap<K, V>

        // HashMap
        // Особенности HashMap:
        // 1. Хранит ключи в hash таблице (на основе hashcode ключей).
        // 2. Обладает хорошей производительностью.
        // 3. В качестве ключа можно использовать null.
        // 4. Порядок хранения элементов может отличаться от порядка добавления.

        // в <> сначала указываем тип данных ключей (в данном случае String), затем тип данных значений (в данном случае User)
        HashMap<String, User> userHashMap = new HashMap<>();
        // добавление элементов. Если ключ уже есть, то значение данного ключа перезапишется
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(cbf.getLogin(),cbf);
        userHashMap.put(rty.getLogin(),rty);
        userHashMap.put(null, null);
        System.out.println(userHashMap);

        // удаление
        userHashMap.remove("asd"); // по ключу
        userHashMap.remove("rty", cbf); // по ключу и значению
        // замена
        userHashMap.replace("rty", null); // по ключу
        userHashMap.replace("rty", null, rty); // по ключу и значению
        System.out.println(userHashMap);

        // получение по ключу
        System.out.println(userHashMap.get("rty"));
        System.out.println(userHashMap.get("asd"));
        // если ключ не найден, вернёт значение по умолчанию (в данном случае cbf)
        System.out.println(userHashMap.getOrDefault("uuu", cbf));
        // проверить, содержиться ли в мапе ключ
        System.out.println(userHashMap.containsKey("uuu"));
        // проверить, содержиться ли в мапе значение
        System.out.println(userHashMap.containsKey(cbf));

        System.out.println("----Перебор мап----");
        for (Map.Entry<String, User> pair : userHashMap.entrySet()) { // перебираем коллекцию Set.Возвращает объект типа Entry
            System.out.println("ключ: " + pair.getKey());
            System.out.println("значение: " + pair.getValue());
        }

        // Особенности EnumMap (самый быстрый из мапов):
        // 1. исопльзует в качестве ключей только Enum'ы
        // 2. нельзя использовать null в качестве ключа
        // 3. все ключи должны быть одного типа перечисления
        // 4. все значения содержит в массиве (размер массива = количеству элементов Enum
        // 5. порядок хранения элементов соответствует порядку записи в Enum
        // 6. для извлечения значений использует индекс ключа: vals[key.ordinal()]

        // при создании объекта в конструктор необходимо передать ссылку на класс перечисления
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        // Arrays.asList(obj1, obj2) - вернет List с obj1 и obj2
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(asd, bnm)));

        System.out.println(enumMap.get(Role.USER));

        // вывести в консоль логины всех пользователей с ролью ADMIN
        System.out.println("-------------------");
        for (User user : enumMap.get(Role.ADMIN)) {
            System.out.println(user.getLogin());
        }

        User newUser = new User("newUser", "111", Role.USER);
        // добавить объект в enumMap, учитывая, что роль объекта может быть не известна
        enumMap.get(newUser.getRole()).add(newUser);

        User someUser = new User("some", "9090", Role.USER);
        // если на объект остались только слабые ссылки, сборщик мусора может удалить такой объект (при нехватке памяти)
        WeakReference<User> weakUser = new WeakReference<>(someUser);
        someUser = null;

        // в WeakHashMap создаются только слабые ссылки. Если на объект нет сильных ссылок, то при вызове сборщика мусора
        // эти ссылки удаляться
        WeakHashMap<Object, String> weakMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakVal = "String";
        weakMap.put(weakKey, weakVal);
        System.out.println(weakMap);
        System.out.println(weakMap.size());
        // обнулили сильные ссылки на объект
        weakKey = null;
        weakVal = null;
        System.gc(); // вызов сборщика мусора
        System.out.println(weakMap); // мапа пустая
        System.out.println(weakMap.size());

        // Особенности TreeMap:
        // 1. хранит элементы в отсортированном по ключам порядке
        // 2. основан на красно-черном дереве
        // 3. null нельзя использовать в качестве ключей
        // 4. класс, объекты которого будут использоваться в качестве ключей должен реализовывать интерфейс Comparable
        // или в конструктор мары необходимо передать Comparator

        userHashMap.remove(null);
        TreeMap<String, User> userTreeMap = new TreeMap<>(userHashMap);
        userTreeMap.put("asd", asd);


    }
}