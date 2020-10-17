package com.ifmo.jjd.lesson9.playlist;

public class Application {
    public static void main(String[] args) {
        PlayList playList = new PlayList();
        for (int i = 0; i < playList.playListLong(); i++) {
            playList.addSong(Service.newSong());
        }
        System.out.println(playList.toString());
    }
}
