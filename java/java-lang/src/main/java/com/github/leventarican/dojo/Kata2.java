package com.github.leventarican.dojo;

/**
 * https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
 * 
 * @author levent
 */
public class Kata2 {

    public static boolean isSquare(int n) {
        System.out.println("in: " + n);
        
        var a = (int) Math.ceil(Math.sqrt(n));
        System.out.println(a);
        
        return a*a == n;
    }
    
    public static void main(String[] args) {
        isSquare(3600);
    }
}
