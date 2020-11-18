package com.github.leventarican.oodesign.composition;

/**
 * object-orientated design: composition and delegation.
 *
 * @author levent
 */
public class Main {
    public static void main(String[] args) {
        var staff = new Developer();
        var manager = new Manager(staff);
        manager.work();
    }
}
