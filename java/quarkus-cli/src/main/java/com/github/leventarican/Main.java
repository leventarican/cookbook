package com.github.leventarican;

import io.quarkus.runtime.QuarkusApplication;
import javax.inject.Inject;

/**
 * @author levent
 */
//@QuarkusMain
public class Main implements QuarkusApplication {
    
    @Inject
    ProgrammingLanguage java;

    @Override
    public int run(String... args) throws Exception {
        System.out.println("Java version: " + this.java.version());
        return 100;
    }
}
