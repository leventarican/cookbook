package com.github.leventarican;

import java.util.Arrays;

/**
 * the java language.
 *
 * @author levent
 */
public class Language {

    public void lang() {
        // a magic number used to identify java class files
        var magicNumber = 0xCAFEBABE;

        var type = "local variables can be type inferred.";

        var v = "case";
        var V = "sensitive";
        System.out.println("java is " + v + V);

        byte a = 127, b = 1;
        byte overflow = (byte) (a + b);
        System.out.println("when exceed range (–128 and 127) then numbers are wrapped: " + overflow);

        byte c = -128, d = 5;
        byte underflow = (byte) (c - d);
        System.out.println(underflow);
    }

    void expressions() {
        var a = "primary expressions consist of literals and variables";
        System.out.println(a);

        // expression examples:
        {
            var b = 1.7;
            var c = true;
            var d = a;
        }

        var b = "complex expressions are made by using operators to combine primary expressions";
        System.out.println(b);

        // example: combine two primary expressions with assignment operator
        {
            b = "assignment expression";
            var c = 1 + 2 * 4.2;
            // this is also a expression, but not a statement: (int)(c + 100)
        }
    }

    // represents constant values
    void literals() {
        Object[] literals = {1, 1.0, '1', 1L, "one", true, false, null};
        Arrays.asList(literals).forEach(System.out::println);
    }

    void statements() {
        // a statement is a basic unit of execution in the java language.
        // it expresses a single piece of intent by the programmer.
        // unlike expressions, java statements do not have a value.

        // labeled statement
        {
            row:
            for (int r = 0; r < 3; r++) {
                System.out.println("row: " + r);
                col:
                for (int c = 0; c < 3; c++) {
                    System.out.println("col: " + c);
                    break row;
                }
            }
        }

        // synchronized statement
        {
            // critical section
//            synchronized (expression) {
//                statement;
//            }
        }

        // throw statement
        {
            try {
                throwStatement(-1);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    void throwStatement(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("x > 0 expected.");
        }
        // empty statement
        ;
    }

    public static void main(String[] args) {
        var app = new Language();
        app.literals();
        app.lang();
        app.expressions();
        app.statements();
    }
}
