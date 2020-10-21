package com.ifmo.jjd.exam1;

public interface ZoneActions {

    // добавляет индекс абонимента в зону
    boolean addAboniment(int indexOfAboniment);

    // проверяет заполненость зоны
    boolean checkFreeSpaceInZone();

    // проверяет абонемент в зоне
    boolean abonnementInZone(int index);
}
