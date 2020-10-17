package com.ifmo.jjd.lesson9.playlist;

import java.util.Arrays;

public class PlayList {
    private Song[] playList = new Song[10];

    public void addSong(Song song) {
        if (song == null) throw new IllegalArgumentException("song == null");
        if (!fullPlayList()) {
            for (int i = 0; i < playList.length; i++) {
                if (playList[i] == null) {
                    playList[i] = song.clone();
                    return;
                }
                if  (playList[i].equals(song)) {
                    return;
                }
            }
        }
        System.out.println("PlayList is full");
    }

    public int playListLong() {
        return playList.length;
    }

    public boolean fullPlayList() {
        for (Song song : playList) {
            if (song == null) {
                return false;
            }
        }
        return true;
    }

    public String playListDuration() {
        int durationInSeconds = 0;
        for (Song song : playList) {
            if (song != null) durationInSeconds += song.getDuration();
        }
        return "PlayList duration is " + durationInSeconds / 60 + " minutes " + durationInSeconds % 60 + "seconds";
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playList=" + Arrays.toString(playList) +
                "playList duration=" + this.playListDuration() +
                '}';
    }
}
