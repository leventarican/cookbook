package com.github.leventarican.dojo;

/**
 * https://www.codewars.com/kata/5b180e9fedaa564a7000009a/train/java
 * https://www.codewars.com/kata/5412509bd436bd33920011bc/train/java
 * https://www.codewars.com/kata/54c27a33fb7da0db0100040e/train/java
 * https://www.codewars.com/kata/5583d268479559400d000064/train/java
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
    
    public static void main(String[] args) {
        upperOrLowerCaseOnly("COde");
        maskify("4556364607935616");
        isSquare(9);
        binaryToText("0100100001100101011011000110110001101111");
    }
}
