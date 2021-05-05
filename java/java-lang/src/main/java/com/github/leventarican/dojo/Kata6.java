package com.github.leventarican.dojo;

/**
 * https://www.codewars.com/kata/58fa273ca6d84c158e000052/train/java
 * https://www.codewars.com/kata/535474308bb336c9980006f2/train/java
 *
 * @author levent
 */
public class Kata6 {

    static int digits(long n) {
        return String.valueOf(n).length();
    }

    static String greet(String name) {
        String[] a = name.toLowerCase().split("");
        a[0] = a[0].toUpperCase();
        StringBuilder b = new StringBuilder();
        b.append("Hello ");
        for (String s : a) {
            b.append(s);
        }
        b.append("!");
        System.out.println(b.toString());
        return b.toString();
    }

    public static void main(String[] args) {
        digits(1234);
        greet("JaVA");
    }
}
