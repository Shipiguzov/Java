package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalTime;

public class Abonnement {
    private Human owner;
    private LocalDate registrationDate;
    private LocalDate expireDate;
    private boolean pool;
    private boolean gym;
    private boolean group;
    private String type;
    private LocalTime beginWorkTime;
    private LocalTime endWorkTime;
    private int counterOfComing = 0;

    public Abonnement(Human owner, LocalDate registrationDate, LocalDate expireDate, String type) {
        if (type == null || (!Random.ONCE.equalsIgnoreCase(type.trim()) && !Random.DAY.equalsIgnoreCase(type.trim()) && !Random.FULL.equalsIgnoreCase(type.trim())))
            throw new IllegalArgumentException("Wrong type of aboniment");
        this.setOwner(owner);
        this.setRegistrationDate(registrationDate);
        this.setExpireDate(expireDate);
        switch (type.toLowerCase()) {
            case Random.ONCE:
                pool = true;
                gym = true;
                group = false;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(22, 00);
                this.type = type;
                break;
            case Random.DAY:
                pool = false;
                gym = true;
                group = true;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(16, 00);
                this.type = type;
                break;
            case Random.FULL:
                pool = true;
                gym = true;
                group = true;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(22, 00);
                this.type = type;
                break;
        }
    }

    public void setOwner(Human owner) {
        if (owner == null) throw new IllegalArgumentException("owner == null");
        this.owner = owner;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate.isAfter(Random.getCurrentDateTime().toLocalDate()))
            throw new IllegalArgumentException("Registration date in future");
        this.registrationDate = registrationDate;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        if (expireDate.isBefore(registrationDate))
            throw new IllegalArgumentException("Expire date before registration date");
        this.expireDate = expireDate;
    }

    public String getType() {
        return type;
    }

    public int getCounterOfComing() {
        return counterOfComing;
    }

    public void addCounterOfComing() {
        this.counterOfComing++;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isGym() {
        return gym;
    }

    public boolean isGroup() {
        return group;
    }

    public LocalTime getBeginWorkTime() {
        return beginWorkTime;
    }

    public LocalTime getEndWorkTime() {
        return endWorkTime;
    }

    public Human getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Abonement{" +
                "owner=" + owner +
                ", registrationDate=" + registrationDate +
                ", expireDate=" + expireDate +
                ", type=" + type +
                '}';
    }
}
