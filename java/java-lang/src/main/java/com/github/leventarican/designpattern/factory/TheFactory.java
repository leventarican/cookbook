package com.github.leventarican.designpattern.factory;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Helps to create a object.
 * @author Levent
 */
public class TheFactory {

    private static Logger log = Logger.getLogger(TheFactory.class.getSimpleName());
    private static Date productionDate;
    
    /*
     * Default constructor is private. You cant create new object.
     */
    private TheFactory() {
    }
    
    /**
     * @return build a default car.
     */
    public static Car build() {
        Car car = new Car(110, "b");
        return car;
    }

}