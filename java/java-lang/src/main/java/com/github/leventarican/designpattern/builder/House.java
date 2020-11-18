package com.github.leventarican.designpattern.builder;

/**
 * we need a Builder for this class
 *
 * @author levent
 */
public class House {

    private int doors;
    private int windows;
    private Roof roof;

    public House(int doors, int windows, Roof roof) {
        this.doors = doors;
        this.windows = windows;
        this.roof = roof;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public Roof getRoof() {
        return roof;
    }

    public void setRoof(Roof roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return String.format("house# doors: %d; windows: %d; roof: %s", doors, windows, roof.getDescription());
    }

}

enum Roof {
    FLAT(1), GABLE(2), BUTTERFLY(3);
    private String description;

    public String getDescription() {
        return description;
    }

    private Roof(int type) {
        switch (type) {
            case 1:
                description = "flat roof";
                break;
            case 2:
                description = "gable roof";
                break;
            case 3:
                description = "butterfly roof";
                break;
        }
    }

}
