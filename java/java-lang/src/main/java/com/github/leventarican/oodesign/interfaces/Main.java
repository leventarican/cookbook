package com.github.leventarican.oodesign.interfaces;

/**
 * you can safely add non-abstract methods to an abstract class;
 * whereas in interfaces you can add new method as default with an implementation;
 *
 * @author levent
 */
public class Main {
    public static void main(String[] args) {
        var dev = new PythonDeveloper();
        dev.code();
        dev.mlframework();
    }
}
