package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public final class Fitness implements FitnessAction {
    private Zone pool = new Zone(Random.pool);
    private Zone gym = new Zone(Random.gym);
    private Zone group = new Zone(Random.group);
    private LocalTime startWork = LocalTime.of(8, 00);
    private LocalTime endWork = LocalTime.of(22, 00);
    private Abonnement[] abonnementList = new Abonnement[1000];

    public static Abonnement createRandomAboniment() {
        LocalDate temp = Random.randomDate(2020, 2020, 1, 10, 1, 17);
        int typeOfAboniment = Random.random(0, 2);
        switch (typeOfAboniment) {
            case 1:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp,
                        Random.ones
                ) {
                };
            case 2:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp.plusMonths(Random.random(2, 12)),
                        Random.day
                ) {
                };
            case 3:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp.plusMonths(Random.random(2, 12)),
                        Random.full
                ) {
                };
        }
        return null;
    }

    @Override
    public boolean fitnessWork(LocalTime time) {
        return (time.isAfter(this.startWork) && time.isBefore(this.endWork));
    }

    @Override
    public void addAboniment() {
        int count = 0;
        for (int i = 0; i < this.abonnementList.length; i++) {
            if (this.abonnementList[i] == null) {
                this.abonnementList[i] = this.createRandomAboniment();
                return;
            }
            count++;
        }
        if (count == this.abonnementList.length) System.out.println("There is no place for new aboniment");
    }

    @Override
    public void closeFitness() {
        pool.clearZone();
        gym.clearZone();
        group.clearZone();
    }

    @Override
    public Abonnement getAboniment(int index) {
        if (index < 0) throw new IllegalArgumentException("Index of aboniment must not less 0");
        return abonnementList[index];
    }

    @Override
    public boolean accessToZone(Abonnement abonnement, String zone) {
        boolean flag = true;
        switch (zone) {
            case Random.pool:
                if (!abonnement.isPool()) flag = false;
                break;
            case Random.gym:
                if (!abonnement.isGym()) flag = false;
                break;
            case Random.group:
                if (!abonnement.isGroup()) flag = false;
                break;
        }
        if (!flag) System.out.println("Sorry, but you cann't go to " + zone + " lesson");
        return flag;
    }

    @Override
    public boolean addAbonnentToZone(int index, String zoneType) {
        switch (zoneType) {
            case Random.pool:
                if (this.pool.checkFreeSpaceInZone()) {
                    this.pool.addAboniment(index);
                    System.out.println("Abonnement " + this.getAboniment(index).toString() + " add to " + zoneType);
                    getAboniment(index).addCounterOfComing();
                    return true;
                }
            case Random.gym:
                if (this.gym.checkFreeSpaceInZone()) {
                    this.gym.addAboniment(index);
                    System.out.println("Abonnement " + this.getAboniment(index).toString() + " add to " + zoneType);
                    getAboniment(index).addCounterOfComing();
                    return true;
                }
            case Random.group:
                if (this.group.checkFreeSpaceInZone()) {
                    this.group.addAboniment(index);
                    System.out.println("Abonnement " + this.getAboniment(index).toString() + " add to " + zoneType);
                    return true;
                }
        }
        return false;
    }

    @Override
    public boolean abonimentInZones(int indexOfAbonnement) {
        return (pool.abonnementInZone(indexOfAbonnement) || gym.abonnementInZone(indexOfAbonnement) || group.abonnementInZone(indexOfAbonnement));
    }

    @Override
    public boolean abonimentExpired(Abonnement abonnement, LocalDate time) {
        if ("ones".equals(abonnement.getType()) && abonnement.getCounterOfComing() > 0) return true;
        if (abonnement.getExpireDate().isBefore(time) || abonnement.getExpireDate().isEqual(time)) return true;
        return false;
    }

    @Override
    public void fitnessInfo() {
        pool.zoneInfo(this.abonnementList);
        gym.zoneInfo(this.abonnementList);
        group.zoneInfo(this.abonnementList);
    }

    @Override
    public String toString() {
        return "Fitness{" +
                "abonimentList=" + Arrays.toString(abonnementList) +
                '}';
    }
}
