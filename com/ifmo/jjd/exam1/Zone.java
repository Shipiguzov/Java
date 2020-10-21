package com.ifmo.jjd.exam1;

import java.util.Arrays;

public class Zone implements ZoneActions {
    private int[] abonimentList = new int[20];
    private String type;
    private boolean pool = false;
    private boolean gym = false;
    private boolean group = false;

    public Zone(String type) {
        switch (type) {
            case Random.POOL:
                this.pool = true;
            case Random.GYM:
                this.gym = true;
            case Random.GROUP:
                this.group = true;
        }
        Arrays.fill(abonimentList, -1);
        this.type = type;
    }

    public void setType(String type) {
        if (type == null || (!Random.POOL.equalsIgnoreCase(type.trim()) && !Random.GYM.equalsIgnoreCase(type.trim()) && !Random.GROUP.equalsIgnoreCase(type.trim())))
            throw new IllegalArgumentException("Wrong type of Zone");
        this.type = type;
    }

    public void clearZone() {
        for (int i = 0; i < this.abonimentList.length; i++) {
            this.abonimentList[i] = -1;
        }
    }

    @Override
    public boolean addAboniment(int indexOfAboniment) {
        for (int i = 0; i < this.abonimentList.length; i++) {
            if (this.abonimentList[i] < 0) {
                this.abonimentList[i] = indexOfAboniment;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkFreeSpaceInZone() {
        int count = 0;
        for (int i : this.abonimentList) {
            if (i < 0) return true;
        }
        System.out.println("There is no free space in " + this.type);
        return false;
    }

    @Override
    public boolean abonnementInZone(int index) {
        for (int i : abonimentList) {
            if (index == i) return true;
        }
        return false;
    }

    public void zoneInfo(Abonnement[] abonnements) {
        int count = 0;
        System.out.println("Now in zone " + this.type + " :");
        for (int i = 0; i < this.abonimentList.length; i++) {
            if (this.abonimentList[i] >= 0) {
                System.out.println(abonnements[i].toString());
                count++;
            }
        }
        count = this.abonimentList.length - count;
        System.out.println("There is " + count + " free space.");
    }

    @Override
    public String toString() {
        return "Zone{" +
                "abonimentList=" + Arrays.toString(abonimentList) +
                ", type='" + type + '\'' +
                '}';
    }
}
