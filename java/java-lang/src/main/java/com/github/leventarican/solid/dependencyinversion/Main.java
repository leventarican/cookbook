package com.github.leventarican.solid.dependencyinversion;

/**
 * @author levent
 */
public class Main {
    public static void main(String[] args) {
        var dev = new Developer(new Framework(("quarkus")));
        dev.code();
    }
}
