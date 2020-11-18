package com.github.leventarican.solid.liskovsubstitution;

/**
 * @author levent
 */
public class Computer {
    public void compile(Code code) {
        System.out.println(String.format("compiling %s ...", code.language()));
    }
}
