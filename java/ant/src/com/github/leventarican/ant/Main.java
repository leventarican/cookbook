package com.github.leventarican.ant;

public class Main {
    public static void main(String[] args) {
        for (int i=0; i<args.length; i++) {
            System.out.println("arg-" + i + ": " + args[i]);
        }
    }
}