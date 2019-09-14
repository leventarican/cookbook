package com.github.leventarican.designpattern.factory;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * POJO
 * @author Levent
 */
public class Car {
    private Logger log = Logger.getLogger(Car.class.getSimpleName());
    private final long id;
    private final String fuel;
    private final Date productionDate;

    public Car(long id, String fuel) {
        this.id = id;
        this.fuel = fuel;
        this.productionDate = Calendar.getInstance().getTime();
    }

    @Override
    public String toString() {
        String payload = String.format("Car id: %d; fuel: %s; production date: %s", id, fuel, productionDate);
        log.info(payload);
        return payload;
    }
}