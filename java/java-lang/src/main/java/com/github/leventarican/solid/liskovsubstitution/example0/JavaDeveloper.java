package com.github.leventarican.solid.liskovsubstitution.example0;

/**
 * we assume that a java developer write code in JVM compatible code: java,
 * kotlin, scale, groovy.
 *
 * @author levent
 */
public class JavaDeveloper {

    @Deprecated
    public void code(Code code) {
        System.out.println("developer is coding in: " + code.language());
    }

    public void code(JVMCode code) {
        System.out.println("developer is coding in: " + code.language());
    }
}
