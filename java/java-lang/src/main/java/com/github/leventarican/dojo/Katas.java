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
        return null; 
    }

    public static void main(String[] args) {
        makeNegative(-42);
        makeNegative(42);

        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        findNeedle(haystack1);

        abbrevName("Sam Harris");
        
        int[] expectedResult = new int[] {8, -50};
        var a = IntStream.of(expectedResult)
                .mapToObj(i -> "{i}")
                .collect(Collectors.joining());
        System.out.println(a);
        countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14});
    }
}
