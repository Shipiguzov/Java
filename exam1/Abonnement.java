package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Abonnement implements AbonnementActions {
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
        if (type == null || (!"ones".equals(type.trim().toLowerCase()) && !"day".equals(type.trim().toLowerCase()) && !"full".equals(type.trim().toLowerCase())))
            throw new IllegalArgumentException("Wrong type of aboniment");
        this.owner = owner;
        this.setRegistrationDate(registrationDate);
        this.setExpireDate(expireDate);
        switch (type.toLowerCase()) {
            case "ones":
                pool = true;
                gym = true;
                group = false;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(22, 00);
                this.type = type;
                return;
            case "day":
                pool = false;
                gym = true;
                group = true;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(16, 00);
                this.type = type;
                return;
            case "full":
                pool = true;
                gym = true;
                group = true;
                beginWorkTime = LocalTime.of(8, 00);
                endWorkTime = LocalTime.of(22, 00);
                this.type = type;
                return;
        }
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        if (registrationDate.isAfter(Logger.getCurrentDateTime().toLocalDate()))
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
