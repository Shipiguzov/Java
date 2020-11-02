package com.ifmo.jjd.lesson16.hw;

import com.ifmo.jjd.lesson6.garden.Tree;

import java.util.*;

public class MapTask {
    public static void main(String[] args) {

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";
        List<String> newList = getCitizensFromCity(firstTaskMap, city);
        System.out.println(newList);
        System.out.println("__________________________________");

        // дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        // в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");
        Map<String, Integer> wordsMap = countEqualWords(words);
        System.out.println(wordsMap);
        System.out.println("____________________________");


        // дана мапа (customerMap).
        // Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        // в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        HashMap<String, Customer> newMap = getAge(customerMap, 18, 50);
        System.out.println(newMap);
        System.out.println("___________________________________");


        // Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        TreeMap<String, Integer> wordsInTextMap = makeTreeMapFromString(text);
        String word = "uncover";
        System.out.println("Word " + word + " meets " + wordInText(wordsInTextMap, word) + " times in text");
        HashMap<Integer, ArrayList<String>> hashMap = charsWords(wordsInTextMap);
        System.out.println(hashMap);
        TreeMap<Integer, ArrayList<String>> wordFrequency = wordFrequency(wordsInTextMap);
        System.out.println("Word frequency: " + wordFrequency);
        TreeMap<Integer, ArrayList<String>> frequencyReverce = new TreeMap(wordFrequency.descendingMap());
        System.out.println(frequencyReverce);
        showWord(frequencyReverce, 10);
        TreeMap<Integer, Character> charFrequency = new TreeMap<>();
        charFrequencyInMap(wordFrequency);
        System.out.println(charFrequencyInPercent(charFrequencyInMap(wordFrequency), text.length()));
    }

    private static TreeMap<Character, Double> charFrequencyInPercent(TreeMap<Character, Integer> treeMap, int textLength) {
        TreeMap<Character, Double> charFrequencyInPercent = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
            double temp = (double) entry.getValue() / textLength * 100;
            charFrequencyInPercent.put(entry.getKey(), temp);
        }
        return charFrequencyInPercent;
    }

    // считает, сколько раз встречается буквы в тексте
    private static TreeMap<Character, Integer> charFrequencyInMap(TreeMap<Integer, ArrayList<String>> treeMap) {
        TreeMap<Character, Integer> charFrequency = new TreeMap<>();
        for (Map.Entry<Integer, ArrayList<String>> entry : treeMap.entrySet()) {
            HashMap<Character, Integer> characterInWord;
            for (String word : entry.getValue()) {
                characterInWord = charInWord(word);
                for (Map.Entry<Character, Integer> entry1 : characterInWord.entrySet()) {
                    int temp;
                    if (charFrequency.containsKey(entry1.getKey())) {
                        temp = charFrequency.get(entry1.getKey()) + entry1.getValue() * entry.getKey();
                        charFrequency.put(entry1.getKey(), temp);
                    } else {
                        temp = entry1.getValue() * entry.getKey();
                        charFrequency.put(entry1.getKey(), temp);
                    }
                }
            }
        }
        return charFrequency;
    }

    // считает, сколько буква встречается в слове
    private static HashMap<Character, Integer> charInWord(String word){
        int count = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            int temp;
            if (hashMap.containsKey(word.charAt(i))) {
                temp = hashMap.get(word.charAt(i)) + 1;
                hashMap.put(word.charAt(i), temp);
            } else {
                hashMap.put(word.charAt(i), 1);
            }
        }
        return hashMap;
    }

    // показывает сколько слово встречается в тексте (первые count слов)
    private static void showWord(TreeMap<Integer, ArrayList<String>> treeMap, int count) {
        int innerCount = 0;
        for (Map.Entry<Integer, ArrayList<String>> entry : treeMap.entrySet()) {
            if (innerCount >= count) break;
            for (String value : entry.getValue()) {
                if (innerCount >= count) break;
                System.out.println("word " + value + " meets " + entry.getKey() + " times in text");
                innerCount++;
            }
        }
    }

    // считает, сколько слова встречается в тексте
    private static TreeMap<Integer, ArrayList<String>> wordFrequency(TreeMap<String, Integer> treeMap) {
        TreeMap<Integer, ArrayList<String>> frequency = new TreeMap<>();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            ArrayList<String> tempList = new ArrayList<>();
            if (frequency.get(entry.getValue()) == null) {
                tempList.add(entry.getKey());
            } else {
                tempList.addAll(frequency.get(entry.getValue()));
                tempList.add(entry.getKey());
            }
            frequency.put(entry.getValue(), tempList);
        }
        return frequency;
    }

    // выводит список слов, отсортированный по количеству букв в слове, из текста. Без повторяющихся слов
    private static HashMap<Integer, ArrayList<String>> charsWords(TreeMap<String, Integer> treeMap) {
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            ArrayList<String> tempList = new ArrayList<>();
            if (hashMap.get(entry.getKey().length()) == null) {
                tempList.add(entry.getKey());
            } else {
                tempList.addAll(hashMap.get(entry.getKey().length()));
                if (!tempList.contains(entry.getKey())) tempList.add(entry.getKey());
            }
            hashMap.put(entry.getKey().length(), tempList);
        }
        return hashMap;
    }

    // показывает, сколько слово встречается в тексте.
    private static int wordInText(TreeMap<String, Integer> treeMap, String word) {
        return treeMap.get(word);
    }


    private static TreeMap<String, Integer> makeTreeMapFromString(String string) {
        TreeMap<String, Integer> newTreeMap;
        List<String> listOfWords;
        listOfWords = Arrays.asList(string.split(" "));
        newTreeMap = new TreeMap<>(countEqualWords(listOfWords));
        return newTreeMap;
    }

    public static HashMap<String, Customer> getAge(HashMap<String, Customer> customerMap, int from, int to) {
        // дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает новую мапу,
        //  в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> customer : customerMap.entrySet()) {
            if (customer.getValue().getAge() >= from && customer.getValue().getAge() < to)
                newMap.put(customer.getKey(), customer.getValue());
        }
        return newMap;
    }

    public static List<String> getCitizensFromCity(HashMap<String, String> citizenList, String city) {
        // написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        List<String> tempList = new ArrayList<>();
        for (Map.Entry<String, String> entry : citizenList.entrySet()) {
            if (city.equals(entry.getValue())) tempList.add(entry.getKey());
        }
        return tempList;
    }

    public static Map<String, Integer> countEqualWords(List<String> list) {
        // дан список слов (words). Написать метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        Map<String, Integer> equalWords = new HashMap<>();
        for (String str : list) {
            if (equalWords.containsKey(str)) equalWords.replace(str, equalWords.get(str) + 1);
            else equalWords.put(str, 1);
        }
        return equalWords;
    }
}