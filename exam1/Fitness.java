package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public final class Fitness implements FitnessAction {
    private Zone pool = new Zone("pool");
    private Zone gym = new Zone("gym");
    private Zone group = new Zone("group");
    private LocalTime startWork = LocalTime.of(8, 00);
    private LocalTime endWork = LocalTime.of(22, 00);
    private Abonnement[] abonnementList = new Abonnement[1000];

    @Override
    public boolean fitnessWork(LocalTime time) {
        if (time.isAfter(this.startWork) && time.isBefore(this.endWork)) return true;
        return false;
    }

    @Override
    public Abonnement createRandomAboniment() {
        LocalDate temp = Logger.randomDate(2020, 2020, 1, 10, 1, 17);
        int typeOfAboniment = Logger.random(1, 3);
        switch (typeOfAboniment) {
            case 1:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp,
                        "ones"
                ) {
                };
            case 2:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp.plusMonths(Logger.random(2, 12)),
                        "day"
                ) {
                };
            case 3:
                return new Abonnement(
                        Human.createRandomHuman(),
                        temp,
                        temp.plusMonths(Logger.random(2, 12)),
                        "full"
                ) {
                };
        }
        return null;
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
        switch (zone) {
            case "pool":
                if (!abonnement.isPool()) {
                    System.out.println("Sorry, but you cann't go to the pool");
                    return false;
                }
                return true;
            case "gym":
                if (!abonnement.isGym()) {
                    System.out.println("Sorry, but you cann't go to the gym");
                    return false;
                }
                return true;
            case "group":
                if (!abonnement.isGroup()) {
                    System.out.println("Sorry, but you cann't go to the group lessons");
                    return false;
                }
                return true;
        }
        return false;
    }

    @Override
    public boolean addAbonnentToZone(int index, String zoneType) {
        switch (zoneType) {
            case "pool":
                if (this.pool.checkFreeSpaceInZone()) {
                    this.pool.addAboniment(index);
                    System.out.println("Abonnement " + this.getAboniment(index).toString() + " add to " + zoneType);
                    getAboniment(index).addCounterOfComing();
                    return true;
                }
            case "gym":
                if (this.gym.checkFreeSpaceInZone()) {
                    this.gym.addAboniment(index);
                    System.out.println("Abonnement " + this.getAboniment(index).toString() + " add to " + zoneType);
                    getAboniment(index).addCounterOfComing();
                    return true;
                }
            case "group":
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
        if (pool.abonnementInZone(indexOfAbonnement) || gym.abonnementInZone(indexOfAbonnement) || group.abonnementInZone(indexOfAbonnement))
            return true;
        return false;
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
