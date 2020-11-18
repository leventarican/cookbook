package com.github.leventarican.designpattern.builder;

/**
 *
 * @author levent
 */
public class HouseBuilder {
    private int doors;
    private int windows;
    private Roof roof;
    
    public HouseBuilder setDoors(int doors) {
        this.doors = doors;
        return this;
    }
    
    public HouseBuilder setWindows(int windows) {
        this.windows = windows;
        return this;
    }
    
    public HouseBuilder setRoof(Roof roof) {
        this.roof = roof;
        return this;
    }
    
    public House build() {
        return new House(doors, windows, roof);
    }
}
