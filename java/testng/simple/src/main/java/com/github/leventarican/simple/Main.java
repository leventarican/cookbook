package com.github.leventarican.simple;

import java.util.stream.Stream;

/**
 * @author Levent
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("testng");
        
        Stream.of(args).forEach((arg) -> System.out.println(arg));
    }
}
