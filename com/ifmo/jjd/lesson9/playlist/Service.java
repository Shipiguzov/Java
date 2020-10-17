package com.ifmo.jjd.lesson9.playlist;

public class Service {

    public static Song newSong() {
        return new Song(
                randomString(1, 2),
                random(1, 100),
                singer()
        );
    }

    private static String randomString(int min, int max) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < random(min, max); i++) {
            name.append(letter(random(1, 2)));
        }
        return name.toString();
    }

    private static Singer singer() {
        return new Singer(randomString(1, 4), randomString(1, 4));
    }

    private static int random(int minRange, int maxRange) {
        return (int) (Math.random() * (maxRange - minRange + 1) + minRange);
    }

    private static String letter(int number) {
        switch (number) {
            case 1:
                return "abc";
            case 2:
                return "hfy";
            case 3:
                return "kfi";
            case 4:
                return "loi";
            case 5:
                return "ert";
            case 6:
                return "uyt";
            case 7:
                return "njk";
            case 8:
                return "qwe";
        }
        throw new IllegalArgumentException("number in letter out of range");
    }
}
