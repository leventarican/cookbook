package com.github.leventarican;

import java.util.StringTokenizer;

/**
 *
 * @author levent
 */
public class UnderConstruction {
    
    static void tokenizer() {
        StringTokenizer tokenizer = new StringTokenizer("java|is|a|oop|language.", "|");
        while (tokenizer.hasMoreElements()) {
            String next = (String) tokenizer.nextElement();
            System.out.println(next);
        }
        
        Runnable r = () -> {
            System.out.println("");
        };  
    }
    
    static void odd_even(int number) {
        System.out.println(String.format("number %d is even: %b", number, (number % 2) == 0));
    }
    
    static void odd_even1(int number) {
        // 2 => 0b010
        boolean even = (number & 1) == 0;
        System.out.println(String.format("even %b", even));
        
        System.out.println("0b0000_0001: " + 0b00000001);
    }
    
    static void swap() {
        int a = 7;
        int b = 2;
        
        // 7 = 0b111
        // 2 = 0b010
        a ^= b;
        b ^= a;
        a ^= b;
        
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
    
    static void buffer() {
        // String is immutable
        StringBuffer b = new StringBuffer("competitive programming");
        System.out.println("capacity: " + b.capacity());
        
        b.insert(11, "#");
        System.out.println(b);
    }
    
    public static void main(String[] args) {
        tokenizer();
        
        odd_even(7);
        odd_even(2);
        
        odd_even1(7);
        odd_even1(2);
        
        swap();
        
        buffer();
    }
}