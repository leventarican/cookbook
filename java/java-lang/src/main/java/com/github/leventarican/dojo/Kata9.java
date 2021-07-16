package com.github.leventarican.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/java
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java
 * https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
 * https://www.codewars.com/kata/5583d268479559400d000064/train/java
 * https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java
 * https://www.codewars.com/kata/5ac6932b2f317b96980000ca/train/java
 * https://www.codewars.com/kata/57ee99a16c8df7b02d00045f/train/java
 * https://www.codewars.com/kata/5583090cbe83f4fd8c000051/train/java
 * https://www.codewars.com/kata/54da5a58ea159efa38000836/train/java
 *
 * @author levent
 */
public class Kata9 {

    /*
    if lower and upper case are equal then return lowercase
     */
    static String upperOrLowerCaseOnly(final String str) {
        System.out.println("input: " + str);

        if (str.isEmpty()) {
            return "";
        }

        int count = 0;
        // A=65 ... Z=90
        // a=97 ... z=122
        for (int i = 0; i < str.length(); i++) {
            int ascii = str.codePointAt(i);
            if (ascii < 90) {
                count++;
            }
        }

        String solution = count > str.length() / 2 ? str.toUpperCase() : str.toLowerCase();
        System.out.println(solution);

        return solution;
    }

    /*
    return s.length() < 2 * s.replaceAll("[a-z]","").length() ? s.toUpperCase() :s.toLowerCase();
     */
    static String maskify(String str) {
        StringBuilder a = new StringBuilder();

        if (str.length() > 4) {
            int b = str.length() - 4;
            String mask = "#".repeat(b);
            String lastFour = str.substring(b, str.length());
            a.append(mask);
            a.append(lastFour);
        } else {
            return str;
        }

        String solution = a.toString();
        System.out.println(solution);

        return solution;
    }

    /*
    return str.replaceAll(".(?=.{4})", "#");
    
    char[] strChars = str.toCharArray();
    for( int i = 0; i < strChars.length - 4; i++ ) {
        strChars[i] = '#';
    }
    return new String(strChars);
     */
    static boolean isSquare(int n) {
        double a = (double) n;
        int b = (int) Math.sqrt(a);

        System.out.println(b);

        return b * b == n;
    }

    /*
    return Math.sqrt(n) % 1 == 0;
    
    long s = Math.round(Math.sqrt(n));
    return s * s == n;
     */
 /*
    input: a binary string
    8 bit represent 1 (ASCII) character
     */
    static String binaryToText(String binary) {
        if (binary.length() < 8) {
            return "";
        }

        String[] a = binary.split("");
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < a.length; i += 8) {
            String b = binary.substring(i, i + 8);
            int c = binaryToInt(b);
            char d = (char) c;
            System.out.println("-> " + d);
            buffer.append(d);
        }

        String solution = buffer.toString();
        System.out.println(solution);

        return solution;
    }

    /*
    StringBuilder value = new StringBuilder();
    for (int i=0; i<binary.length(); i=i+8) {
        value.append((char) Integer.parseInt(binary.substring(i, i + 8),2));
    }
    return value.toString();
    
    return iterate(0, i -> i < binary.length(), i -> i + 8)
        .mapToObj(i -> "" + (char) Integer.parseInt(binary.substring(i, i + 8), 2))
        .collect(joining());
     */
 /*
    use Integer.parseInt(s="01...", radix=2) instead
    
    8 bit binary to integer
    128 64 32 16 8 4 2 1
     */
    static int binaryToInt(String binary) {
        int solution = 0;
        if (binary.length() == 8) {
            for (int i = binary.length() - 1; i >= 0; i--) {
                char a = binary.charAt(i);
                if (i == binary.length() - 1) {
                    if (a == '1') {
                        solution += 1;
                    }
                } else if (i == binary.length() - 2) {
                    if (a == '1') {
                        solution += 2;
                    }
                } else if (i == binary.length() - 3) {
                    if (a == '1') {
                        solution += 4;
                    }
                } else if (i == binary.length() - 4) {
                    if (a == '1') {
                        solution += 8;
                    }
                } else if (i == binary.length() - 5) {
                    if (a == '1') {
                        solution += 16;
                    }
                } else if (i == binary.length() - 6) {
                    if (a == '1') {
                        solution += 32;
                    }
                } else if (i == binary.length() - 7) {
                    if (a == '1') {
                        solution += 64;
                    }
                } else if (i == binary.length() - 8) {
                    if (a == '1') {
                        solution += 128;
                    }
                }
            }
        }
        return solution;
    }

    static boolean smallEnough(int[] a, int limit) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > limit) {
                return false;
            }
        }
        return true;
    }

    // 4 3 5 -> 4*3; 4*5; 3*5
    // 10,8,7,9
    static long maxProduct(int[] numbers, int sub_size) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("size: " + sub_size);
        if (numbers.length >= 3) {
            long a = 1;
            for (int i = 0; i < sub_size; i++) {
                int b = numbers[numbers.length - 1 - i];
                a *= b;
            }
            System.out.println("return a " + a);
            return a;
        }
        return 0;
    }

    /*
    Arrays.sort(numbers);
    long result = 1;
    for (int i = numbers.length-1;sub_size > 0;sub_size--,i--) {
        result*=numbers[i];
    }
    return result;
    
    return stream(numbers)
        .sorted()
        .skip(numbers.length-subSize)
        .mapToLong(Long::valueOf)
        .reduce(1, (x,y)->x*y);
     */
    static int minValue(int[] values) {
        Arrays.sort(values);
        Set<String> a = new HashSet();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String b = String.valueOf(value);
            a.add(b);
        }
        StringBuilder c = new StringBuilder();
        for (String s : a) {
            System.out.println(s);
            c.append(s);
        }
        int d = Integer.valueOf(c.toString());
        System.out.println("solution: " + d);
        return d;
    }

    /*
    return Arrays.stream(values)
       .distinct()
       .sorted()
       .reduce(0, (a, b) -> 10 * a + b);
     */

 /*
    null is argument is null or empty
     */
    static String capitalizeWords(String s) {
        System.out.println();
        if (s != null) {
            if (!s.isEmpty()) {
                StringBuilder solution = new StringBuilder();
                String[] words = s.split(" ");
                for (int i = 0; i < words.length; i++) {
                    String word = words[i];
                    String w = word.substring(0, 1).toUpperCase() + word.substring(1, word.length());
                    solution.append(w);
                    solution.append(" ");
                }
                System.out.println(solution);
                return solution.toString().trim();
            }
        }
        return null;
    }

    /*
    return Arrays.stream(phrase.split(" "))
        .map(i -> i.substring(0, 1).toUpperCase() + i.substring(1, i.length()))
        .collect(Collectors.joining(" "));
     */

    static int[] flattenAndSort(int[][] array) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int b = array[i][j];
                a.add((Integer) b);
            }
        }
        int[] c = a.stream().mapToInt(i -> i).toArray();
        Arrays.sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]); 
        }
        return c;
    }

    static int[] digitize(long n) {
        String[] a = String.valueOf(n).split("");
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = Integer.valueOf(a[b.length -1 - i]);
        }
        System.out.println(b);
        return b;
    }
    /*
    return new StringBuilder().append(n)
                          .reverse()
                          .chars()
                          .map(Character::getNumericValue)
                          .toArray();
    */
    
    static int findIt(int[] a) {
        for (int i = 0; i < a.length; i++) {
            Arrays.sort(a);
            int n = a[i];
            int c = 0;
            if (i != 0 && a[i-1] == n) {
                continue;
            }
            for (int j = i; j < a.length; j++) {
                int m = a[j];
                if (n == m) {
                    c++;
                }
            }
            if (c % 2 > 0) {
                System.out.println(n + " -> " + c);
                return n;
            }
        }
        return 0;
    }
    /*
    int xor = 0;
    for (int i = 0; i < A.length; i++) {
      xor ^= A[i];
    }
    return xor;
    
    return stream(arr).reduce(0, (x, y) -> x ^ y);
    
    final TreeSet<Integer> set = new TreeSet<>();
    for (int x : A) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }
    return set.first();
    
    return Arrays.stream(a)
                 .boxed()
                 .collect(Collectors.groupingBy(Function.identity()))
                 .entrySet()
                 .stream()
                 .filter(e -> e.getValue().size() % 2 == 1)
                 .mapToInt(e -> e.getKey())
                 .findFirst()
                 .getAsInt();
    */
    
    public static void main(String[] args) {
        upperOrLowerCaseOnly("COde");
        maskify("4556364607935616");
        isSquare(9);
        binaryToText("0100100001100101011011000110110001101111");
        smallEnough(new int[]{66, 101}, 200);
        maxProduct(new int[]{4, 3, 5}, 2);
        minValue(new int[]{4, 7, 5, 7});
        capitalizeWords("java And kotlin runs on JVM");
        flattenAndSort(new int[][]{{3, 2, 1}, {7, 9, 8}, {6, 4, 5}});
        digitize(718);
        findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5});
    }
}
