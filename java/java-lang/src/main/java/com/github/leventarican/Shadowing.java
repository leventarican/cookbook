package com.github.leventarican;

/**
 * @author levent
 */
public class Shadowing {
    String value = "foobar";
    
    public void ping() {
        String value = "shadowing attribute: foobar";
        System.out.println(value);
    }
    
    public static void main(String[] args) {
        new Shadowing().ping();
    }
}
