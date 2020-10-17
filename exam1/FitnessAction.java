package com.ifmo.jjd.exam1;

import java.time.LocalDate;
import java.time.LocalTime;

public interface FitnessAction {

    // проверяет работает ли фитнес в указанное время
    boolean fitnessWork(LocalTime time);

    // случайно создает абонимент
    Abonnement createRandomAboniment();

    // добавляет абонимент в список
    void addAboniment();

    // фитнесс закрывается
    void closeFitness();

    // возвращает абонимент по инрексу
    Abonnement getAboniment (int index);

    // проверяет доступ абонимента в зону занятий
    boolean accessToZone(Abonnement abonnement,String zone);

    // добавляет индекс указанного аобнимента в зону при наличии свободных мест
    boolean addAbonnentToZone(int index, String zoneType);

    // проверка зарегистрирован ли абонемент в каких-либо зонах
    boolean abonimentInZones(int indexOfAbonnement);

    // Проверка не просрочен ли абонимент
    boolean abonimentExpired(Abonnement abonnement, LocalDate time);

    //
    void fitnessInfo();
}
