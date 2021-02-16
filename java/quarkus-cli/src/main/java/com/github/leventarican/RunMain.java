package com.github.leventarican;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

/**
 * @author levent
 */
@QuarkusMain
public class RunMain {
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
}
