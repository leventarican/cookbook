package com.github.leventarican;

/**
 * @author levent
 */
public class Stackoverflow {
    String id;

    public Stackoverflow() {
        try {
            new Stackoverflow();
            this.id = "0";
        } catch (StackOverflowError e) {
            // Exception in thread "main" java.lang.StackOverflowError
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) {
        new Stackoverflow();
    }
}
