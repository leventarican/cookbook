package com.github.leventarican.dojo;

/**
 * https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/java
 *
 * @author levent
 */
public class Kata9 {
    
    /*
    if lower and upper case are equal then return lowercase
    */
    static String upperOrLowerCaseOnly(final String str) {        
        System.out.println("input: " + str);
        
        if (str.isEmpty())
            return "";

        int count = 0;
        // A=65 ... Z=90
        // a=97 ... z=122
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.codePointAt(i);
            if (ascii < 90) {
                count++;
            }
        }

        String solution = count > str.length()/2 ? str.toUpperCase() : str.toLowerCase();
        System.out.println(solution);
        
        return solution;
    }
    /*
    return s.length() < 2 * s.replaceAll("[a-z]","").length() ? s.toUpperCase() :s.toLowerCase();
    */

    public static void main(String[] args) {
        upperOrLowerCaseOnly("COde");
    }
}
