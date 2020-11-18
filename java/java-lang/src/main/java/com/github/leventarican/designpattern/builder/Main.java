package com.github.leventarican.designpattern.builder;

/**
 *
 * @author levent
 */
public class Main {

    public static void main(String[] args) {
        var house = new HouseBuilder()
                .setDoors(3)
                .setWindows(5)
                .setRoof(Roof.FLAT)
                .build();
        System.out.println(house);
    }
}
