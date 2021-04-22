//https://www.codewars.com/kata/55685cd7ad70877c23000102/train/java
//https://www.codewars.com/kata/56676e8fabd2d1ff3000000c/train/java
//https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/train/java
//https://www.codewars.com/kata/576bb71bbbcf0951d5000044/train/java

package com.github.leventarican.dojo;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Katas {

    public static int makeNegative(final int x) {
        var a = x > 0 ? x * -1 : x;
        System.out.println(a);
        return a;
    }

    public static String findNeedle(Object[] haystack) {
        var a = Arrays.asList(haystack).indexOf("needle");
        System.out.println(a);
        return "found the needle at position " + a;
    }

    public static String abbrevName(String name) {
        String[] a = name.toUpperCase().split(" ");
        return a[0].charAt(0) + "." + a[1].charAt(0);
    }

    //return an array with count of positives and sum of negatives
    public static int[] countPositivesSumNegatives(int[] input) {
        if ((input == null) || (input.length == 0)) return new int[] {};
//        IntStream.of(input).filter(i -> i>0).reduce((a,b) -> a+b).ifPresent(System.out::println);
        var s = IntStream.of(input).collect(StringBuilder::new,
                StringBuilder::append, 
                StringBuilder::append).toString();
        System.out.println(s);
        var count = IntStream.of(input)
                .filter(i -> i>0)
                .count();
        var sum = IntStream.of(input)
                .filter(i -> i<0)
                .sum();
        System.out.println(count + "; " + sum);
        return new int[] {(int)count, sum};
    }

    // https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java
    static boolean smallEnough(int[] a, int limit) {
        boolean s0 = Arrays.stream(a).noneMatch(i -> i > limit);
        boolean s1 = IntStream.of(a).noneMatch(i -> i > limit);
        System.out.println("0. with streams: " + s0);
        System.out.println("1. with streams: " + s1);
        
        // classic way
        for (int i=0; i<a.length; i++) {
            if (a[i] > limit) {
                return false;
            }
        }
        return true;
    }
    
    // https://www.codewars.com/kata/54ff0d1f355cfd20e60001fc/train/java
    static int factorial(int n) throws IllegalArgumentException {
        
        // corner case
        if (n < 0 || n > 12)
            throw new IllegalArgumentException();
        
        int f = 1;
        for (int i = 1; i < n; i++) {
            f = f * (i+1);
        }
        System.out.println("factorial " + n + " -> " + f);
        return f;
    }
    
    // https://www.codewars.com/kata/554e4a2f232cdd87d9000038/train/java
    static String makeComplement(String dna) {
        
        String a = Arrays.stream(dna.split(""))
                .map(s -> s.equals("T")?"A" : s.equals("A")?"T" : s.equals("G")?"C" : s.equals("C")?"G" : "#")
                .collect(Collectors.joining());
        System.out.println(a);
        
        return "";
    }
    
    static void factorial1(int n) {
        // n! = 1 * 2 * ... * n
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        System.out.println("factorial of " + n + " = " + result);
    }
    
    static void factortial2(int start, int end, int n) {
        System.out.println(String.format("factorial (recursive) s=%d; e=%d; n=%d", start, end, n));
        if (start < end) {
            factortial2(++start, end, start*n);
        }
    }
    
    static void positiveSum(int[] n) {
        int sum = 0;
        for (int i=0; i<n.length; i++) {
            sum += n[i]>0 ? n[i] : 0;
        }
        System.out.println("sum: " + sum);
    }
    
    public static void main(String[] args) {
        makeNegative(-42);
        makeNegative(42);

        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        findNeedle(haystack1);

        abbrevName("Sam Harris");
        
        int[] expectedResult = new int[] {8, -50};
        int[] input = new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        countPositivesSumNegatives(input);
        
        System.out.println("expected: true --> " + smallEnough(new int[] {66, 101}, 200));
        
        factorial(5);
        
        makeComplement("GTAT");
        
        factorial1(5);
        
        factortial2(1, 5, 1);
        
        positiveSum(new int[] {1, -4, 3, 4});
    }
}
