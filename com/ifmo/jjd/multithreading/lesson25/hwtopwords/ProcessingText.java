package com.ifmo.jjd.multithreading.lesson25.hwtopwords;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProcessingText {

    private Map<String, Long> map, result = new HashMap<>();
    private String filePath;
    private int blockSize;

    public ProcessingText(String filePath) {
        this.setFilePath(filePath);
    }

    public Map<String, Long> getMap() {
        return map;
    }

    public Map<String, Long> getResult() {
        return result;
    }

    public void setFilePath(String filePath) {
        if (Objects.isNull(filePath) || filePath.length() < 3) throw new IllegalArgumentException("Wrong text");
        this.filePath = filePath;
    }


    /**
     * Method sorting result map and cut it to number
     * @param number how many words will be in result map (TopNumberWords)
     */
    public void sortingResultMap(int number) {
        result = result.entrySet().stream()
                .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                .limit(number)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    /**
     * Method get a map and put it to result map
     *
     * @param inputMap - piece of text that this method will parse.
     */
    public void processingTextPart(Map<String, Long> inputMap) {
        Map<String, Long> map = inputMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
        System.out.println(inputMap.size() + " words in part");
        synchronized (result) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                result.put(entry.getKey(), result.getOrDefault(entry.getKey() + result.get(entry.getKey()), entry.getValue()));
            }
        }
    }

    /**
     * Method split this.map into a pieces to give it to treads
     *
     * @return map with blockSize or less
     */
    public Map<String, Long> getPartMap() {
        Map<String, Long> newMap = new HashMap<>();
        int count = 0;
        synchronized (map) {
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                if (count == blockSize || count == map.size()) break;
                newMap.put(entry.getKey(), entry.getValue());
                count++;
            }
            for (Map.Entry<String, Long> entry : newMap.entrySet()) {
                map.remove(entry.getKey());
            }
        }
        return newMap;
    }

    /**
     * Method get a text from file this.filePath and calculate a blocksize for every thread (total will be 6 threads).
     * Read text will be store in this.map
     */
    public void getTextFromFile() {
        try {
            this.map = Arrays.stream(Files.readString(Paths.get(this.filePath)).toLowerCase().split("\\W"))
                    .collect(Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                    ));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        map.remove("");
        blockSize = map.size() / 5 - (map.size() / 5 / 6);
        System.out.println("Total words: " + map.size());
    }
}
