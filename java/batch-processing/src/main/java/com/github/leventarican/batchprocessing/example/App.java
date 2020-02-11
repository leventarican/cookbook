package com.github.leventarican.batchprocessing.example;

import com.github.leventarican.batchprocessing.MachineThing;

/**
 * @author Levent
 */
public class App {

    public static void main(String[] args) {
        App app = new App();
        
        MachineThing machine = new MachineThing();
        machine.process();
        machine.toString();
    }
}
