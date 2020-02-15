package com.github.leventarican.batchprocessing.example;

import com.github.leventarican.batchprocessing.MachineThing;
import com.github.leventarican.batchprocessing.prototypes.GenerateFiles;
import java.io.IOException;

/**
 * @author Levent
 */
public class App {

    public static void main(String[] args) throws IOException {
        MachineThing machine = new MachineThing();
        machine.process();
        machine.store();
    }
}
