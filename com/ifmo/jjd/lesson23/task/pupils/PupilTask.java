package com.ifmo.jjd.lesson23.task.pupils;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        // обращение к enum Gender через имя класса - Pupil.Gender
        // Используя Stream API:

        List<Pupil> pupilList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            pupilList.add(Pupil.getInstance());
            for (int j = 0; j < i; j++) {
                if (pupilList.get(j).getNumber() == pupilList.get(i).getNumber()) {
                    pupilList.remove(i);
                    i--;
                    continue;
                }
            }
        }
        System.out.println(pupilList);
        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, List<Pupil>> byGender = pupilList.stream()
                .collect(Collectors.groupingBy(Pupil::getGender, Collectors.toList()));
        System.out.println("Pupil by gender: " + byGender);
        // 2. Найти средний возраст учеников
        double averangeAge = pupilList.stream()
                .collect(Collectors.averagingDouble(Pupil::getAge));
        System.out.println("Avarange age of pupil: " + averangeAge);
        // 3. Найти самого младшего ученика
        System.out.println("Youngest: " + pupilList.stream()
                .min(Comparator.comparingInt(Pupil::getAge))
                .get()
        );
        // 4. Найти самого старшего ученика
        System.out.println("Oldest: " + pupilList.stream()
                .max(Comparator.comparingInt(Pupil::getAge))
                .get()
        );
        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> byYear = pupilList.stream()
                .sorted(Comparator.comparing(p -> p.getBirth().getYear()))
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear(), Collectors.toList()));
        System.out.println("Pupil sorted by BirthYear: " + byYear);
        /*pupilList.stream()
                .sorted(Comparator.comparing(p -> p.getBirth().getYear()))
                .forEach(System.out::print);*/
        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        Map<String, String> uniqueName = pupilList.stream()
                .collect(Collectors.toMap(
                        Pupil::getName,
                        pupil -> pupil.getBirth().toString(),
                        (str1, str2) -> "doubling name"
                        )
                );
        System.out.println("List of unique pupil: " + uniqueName);
        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> sorted = pupilList.stream()
                .sorted(Comparator.comparing(Pupil::getGender).thenComparing(Pupil::getBirth).thenComparing(Pupil::getName))
                .collect(Collectors.toList());
        System.out.println("Sorted: " + sorted);
        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        int fromAge = 18, toAge = 30;
        System.out.println(pupilList.stream()
                .filter(pupil -> (pupil.getAge() >= fromAge) && (pupil.getAge() <= toAge))
                .collect(Collectors.toList())
        );
        // 9. Собрать в список всех учеников с именем=someName
        String someName = pupilList.stream().findAny().get().getName();
        System.out.println("someName = " + someName);
        List<Pupil> withNameSomeName = pupilList.stream()
                .filter(pupil -> someName.equals(pupil.getName()))
                .collect(Collectors.toList());
        System.out.println(withNameSomeName);
        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> genderWithAge = pupilList.stream()
                .collect(Collectors.toMap(
                        Pupil::getGender,
                        Pupil::getAge,
                        Integer::sum)
                );
        System.out.println("Gender with sum age: " + genderWithAge);
    }
}
