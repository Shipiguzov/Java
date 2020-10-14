package com.ifmo.jjd.lesson6.homework1;

import java.util.Arrays;

public class Group {
    private boolean isFull = false;
    private int alpinistsCount;
    private Alpinist[] listOfAlpinists = new Alpinist[10];
    private Mountain mountain;

    public Group(int count) {
        this.setAlpinistsCount(count);
    }

    public int getAlpinistsCount() {
        return alpinistsCount;
    }

    public void setAlpinistsCount(int alpinistsCount) {
        if (alpinistsCount < 0) throw new IllegalArgumentException("Количество альпинистов больше 0");
        this.alpinistsCount = alpinistsCount;
    }

    public boolean isIsfull() {
        return isFull;
    }

    public void setIsfull(boolean isFull) {
        if (isFull != true && isFull != false)
            throw new IllegalArgumentException("Значение isFull должно быть boolean");
        this.isFull = isFull;
    }

    public Alpinist[] getListOfAlpinists() {
        return listOfAlpinists;
    }

    public void setListOfAlpinists(Alpinist nameOfAlpinists) {
        for (int i = 0; i < this.listOfAlpinists.length; i++) {
            if (this.listOfAlpinists[i] == null) {
                break;
            } else if (this.listOfAlpinists[i] == nameOfAlpinists) {
                throw new IllegalArgumentException("В группе уже есть данный альпинист!");
            }
            if ((this.listOfAlpinists[i] != null) && (i == this.listOfAlpinists.length)) {
                throw new IllegalArgumentException("Группа достигла максимального количества");
            }
        }
        for (int i = 0; i < this.listOfAlpinists.length; i++) {
            if (listOfAlpinists[i] == null) {
                this.listOfAlpinists[i] = nameOfAlpinists;
                return;
            }
        }
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        this.mountain = mountain;
    }

    @Override
    public String toString() {
        return "Group{" +
                "isFull=" + isFull +
                ", listOfAlpinists=" + Arrays.toString(listOfAlpinists) +
                ", mountainName=" + mountain +
                '}';
    }
}
