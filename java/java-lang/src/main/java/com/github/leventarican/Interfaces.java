package com.github.leventarican;

/**
 * Interfaces are like classes reference types; since Java 8 its allowed to
 * declare methods that include an implementation (= default methods);
 *
 * @author levent
 */
public class Interfaces implements ProgrammingLang {

    @Override
    public void code(String language) {
        System.out.println("hello " + language);
    }
    
    public static void main(String[] args) {
        var app = new Interfaces();
        app.code();
    }
}

interface ProgrammingLang {
    default void code() {
        System.out.println("hello java");
    }
    
    void code(String language);
}
