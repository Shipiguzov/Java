package com.ifmo.jjd.lesson13.generic.bounded.type.parameters;
// Если в качестве generic указать <T extends Transport>, то carOnService мб типа Transport и любым
// из его наследников соответственно. carOnService доступны методы Transport

// Если в качестве generic указать <T extends Bus>, то carOnService мб типа bus (не Transport) и любым
// из его наследников соответственно. carOnService доступны методы Bus

// Если имплементация интерфейса:
// Transport
// Bus -> Transport -> Repairing
// Tram -> Transport
// тогда T может быть только Bus (Операция логическая И при описании класса)

// Класс - только один и любое количество интерфейсов
public class Garage<T extends Transport & Repairing> {
    private T carOnService;

    public T getCarOnService() {
        return carOnService;
    }

    public void setCarOnService(T carOnService) {
        this.carOnService = carOnService;
    }

    public void serve() {
        carOnService.repair();
    }
}
