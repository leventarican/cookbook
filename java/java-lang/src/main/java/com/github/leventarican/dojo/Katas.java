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

    public static void main(String[] args) {
        makeNegative(-42);
        makeNegative(42);

        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        findNeedle(haystack1);

        abbrevName("Sam Harris");
        
        int[] expectedResult = new int[] {8, -50};
        int[] input = new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        countPositivesSumNegatives(input);
    }
}
