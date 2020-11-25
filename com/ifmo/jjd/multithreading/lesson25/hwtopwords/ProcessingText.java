package com.ifmo.jjd.multithreading.lesson25.hwtopwords;

import java.io.File;
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
     * Method get a map, calculate top2 of common words and put it to result map
     * @param inputMap - piece of text that this method will parse.
     */
    public void processingTextPart(Map<String, Long> inputMap) {
        synchronized (result) {
            Map<String, Long> map = inputMap.entrySet().stream()
                    .sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue()))
                    .limit(2)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            Map.Entry::getValue
                    ));
            System.out.println(inputMap.size() + " words in part");
            this.result.putAll(map);
        }
    }

    /**
     * Method split this.map into a pieces to give it to treads
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
     * Method get a text from file this.filePath and calculate a blocksize for every thread (total will be 6 threads.
     * Read text will be store in this.map
     *
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
        if (map.size() - (map.size() / 5 * 5) > 20) blockSize = map.size() / 5;
        else blockSize = map.size() / 5 - (map.size() / 5 / 6);
        System.out.println("Total words: " + map.size());
    }
}
