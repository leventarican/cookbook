package com.github.leventarican.dojo;

import java.util.Arrays;

/**
 * https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/java
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java
 * https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
 * https://www.codewars.com/kata/5583d268479559400d000064/train/java
 * https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java
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
            String b = binary.substring(i, i+8);
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
            for (int i = binary.length()-1; i >= 0 ; i--) {
                char a = binary.charAt(i);
                if (i == binary.length()-1) {
                    if (a == '1') {
                        solution += 1;
                    } 
                } else if (i == binary.length()-2) {
                    if (a == '1') {
                        solution += 2;
                    } 
                } else if (i == binary.length()-3) {
                    if (a == '1') {
                        solution += 4;
                    } 
                } else if (i == binary.length()-4) {
                    if (a == '1') {
                        solution += 8;
                    } 
                } else if (i == binary.length()-5) {
                    if (a == '1') {
                        solution += 16;
                    } 
                } else if (i == binary.length()-6) {
                    if (a == '1') {
                        solution += 32;
                    } 
                } else if (i == binary.length()-7) {
                    if (a == '1') {
                        solution += 64;
                    } 
                } else if (i == binary.length()-8) {
                    if (a == '1') {
                        solution += 128;
                    } 
                }
            }
        }
        return solution;
    }
    
    static boolean smallEnough(int[] a, int limit) {
        for(int i=0; i<a.length; i++) {
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
                int b = numbers[numbers.length-1-i];
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
    
    public static void main(String[] args) {
        upperOrLowerCaseOnly("COde");
        maskify("4556364607935616");
        isSquare(9);
        binaryToText("0100100001100101011011000110110001101111");
        smallEnough(new int[]{66, 101}, 200);
//        maxProduct(new int[]{4,3,5}, 2);
//        maxProduct(new int[]{10,8,7,9}, 3);
//        maxProduct(new int[]{10,3,-27,-1}, 3);
//        maxProduct(new int[]{14, 29, -28, 39, -16, -48}, 4);
        maxProduct(new int[]{-100, -99, -99, -99, -98, -98, -96, -95, -95, -95, -95, -91, -91, -91, -87, -87, -85, -84, -84, -83, -83, -79, -79, -78, -78, -77, -77, -77, -76, -75, -74, -71, -65, -64, -60, -59, -58, -58, -57, -56, -55, -55, -54, -53, -52, -50, -49, -49, -49, -49, -48, -48, -46, -45, -42, -42, -37, -37, -36, -35, -35, -34, -33, -32, -30, -29, -27, -24, -23, -21, -21, -20, -18, -18, -17, -17, -16, -16, -15, -14, -11, -9, -9, -8, -7, -6, -6, -5, -5, -4, -4, -4, -3, 0, 1, 1, 1, 2, 3, 6, 7, 8, 9, 9, 11, 12, 13, 13, 13, 14, 15, 15, 16, 16, 17, 19, 19, 19, 20, 21, 21, 22, 23, 26, 27, 29, 29, 30, 31, 31, 34, 34, 36, 36, 38, 39, 40, 40, 40, 41, 42, 42, 45, 45, 47, 47, 47, 48, 49, 49, 50, 50, 52, 52, 54, 55, 56, 56, 56, 58, 59, 60, 61, 62, 62, 67, 67, 68, 69, 70, 71, 72, 73, 73, 74, 76, 78, 79, 79, 80, 80, 81, 81, 81, 82, 82, 84, 84, 85, 85, 86, 87, 94, 94, 96, 97, 99, 99}, 49);
    }
}
