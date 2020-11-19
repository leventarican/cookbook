package com.github.leventarican.solid.singleresponsibility;

/**
 * One class should only serve one purpose.
 * 
 * @author levent
 */
public class Main {

    public static void main(String[] args) {
        var a = new Developer();
        var b = new Compiler();
        var c = new Code();
        a.code(c);
        b.compile(c);
    }
}

class Developer {

    void code(Code c) {
        System.out.println("coding " + c.language);
    }

    // Single Responsibility Principle: move to another class
    @Deprecated
    void compile(Code c) {
        System.out.println("compiling " + c.language);
    }
}

class Code {

    String language = "go";
}

class Compiler {

    void compile(Code c) {
        System.out.println("compiling " + c.language);
    }
}
