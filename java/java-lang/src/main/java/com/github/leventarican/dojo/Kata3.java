package com.github.leventarican.dojo;

/**
 * https://www.codewars.com/kata/526571aae218b8ee490006f4/train/java
 * 
 * @author levent
 */
public class Kata3 {
    
    /*
    in: 1234 
    binary representation: 10011010010
    count number of 1
    out: 5
    */
    static int countBits(int n) {
        return Integer.bitCount(1234);
    }
    /*
    return (int) Integer.toBinaryString(n).chars()
          .filter(c -> c == '1')
          .count();
    */
    
    /*
    int i = 0;
    for (int j = n; j > 0; j >>= 1) {
        i += j & 1;
    }
    return i;
    */
    
    /*
    return n == 0 ? 0 : (n & 1) + countBits(n >>> 1);
    */
    
    static void code0() {
        // 11 -> 1011
        String a = Integer.toBinaryString(11);
        System.out.println(a);
        a.chars().filter(c -> c == '1').map(c -> 1).forEach(System.out::println);
    }
    
    static void code1() {
        /*
        negative integer representation in java with two's complement
        0000 0000 0000 0000 0000 0000 0000 1011
        
        Two's Complement: invert digits, then add 1
        1111 1111 1111 1111 1111 1111 1111 0100
        1111 1111 1111 1111 1111 1111 1111 0101
        */
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(-11));
        
        System.out.println("#".repeat(80));
        
        /*
        byte: 8 bits
        1111 1111 1111 1111 1111 1111 1000 0000
        0000 0000 0000 0000 0000 0000 1000 0000
        0000 0000 0000 0000 0000 0000 0100 0000
        0000 0000 0000 0000 0000 0000 0111 1111
        1111 1111 1111 1111 1111 1111 1000 0000
        */
        byte b = (byte) 128;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(128));
        b = (byte) 64;
        System.out.println(Integer.toBinaryString(b));
        b = (byte)(64 + 32 + 16 + 8 + 4 + 2 + 1 + 0);
        // MSB (in this case = 0) bit is reserved for sign: 0111 1111
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(~b));
        
        System.out.println("#".repeat(80));
        
        /*
        0111 1111 1111 1111 1111 1111 1111 1111
        0111 1111 1111 1111 1111 1111 1111 1110
        1000 0000 0000 0000 0000 0000 0000 0000
        1000 0000 0000 0000 0000 0000 0000 0001
        -2147483648
        -2147483647
        1111 1111 1111 1111 1111 1111 1111 1111
        -1
        */
        
        int i = Integer.MAX_VALUE;
        int j = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i-1));
        System.out.println(Integer.toBinaryString(j));
        System.out.println(Integer.toBinaryString(j+1));
        System.out.println(j);
        System.out.println(j+1);
        System.out.println(Integer.toBinaryString(j+j-1));
        System.out.println(j+j-1);
        
        System.out.println("#".repeat(80));
        
        System.out.println(">>>=");
        
        /*
        0000 0000 0000 0000 0000 0000 0000 1011
        0000 0000 0000 0000 0000 0000 0000 0101
        1111 1111 1111 1111 1111 1111 1111 0101
        0111 1111 1111 1111 1111 1111 1111 1010
        */
        
        int n = 11;
        System.out.println(Integer.toBinaryString(n));
        n >>>= 1;
        System.out.println(Integer.toBinaryString(n));
        
        n = -11;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
        n >>>= 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
        
        System.out.println("#".repeat(80));
        
        System.out.println(">>=");
        
        /*
        n >>= 1: 0000 0000 0000 0000 0000 0000 0000 0101
        n = -11: 1111 1111 1111 1111 1111 1111 1111 0101
        n >>= 1: 1111 1111 1111 1111 1111 1111 1111 1010
                 1111 1111 1111 1111 1111 1111 1111 1110
        */
        
        n = 11;
        n >>= 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
        n = -11;
        System.out.println(Integer.toBinaryString(n));
        n >>= 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
        n = -2;
        System.out.println(Integer.toBinaryString(n));
        
        System.out.println("#".repeat(80));
        
        for (int k = 12; k > 0; k--) {
            System.out.println(k + "=" + Integer.toBinaryString(k));
        }
        /*
        8= 0000 0000 0000 0000 0000 0000 0000 1000
        7= 0000 0000 0000 0000 0000 0000 0000 0111
        6= 0000 0000 0000 0000 0000 0000 0000 0110
        */
        for (int k = 0; k > -12; k--) {
            System.out.println(k + "=" + Integer.toBinaryString(k));
        }
        /*
        -1= 1111 1111 1111 1111 1111 1111 1111 1111
        -2= 1111 1111 1111 1111 1111 1111 1111 1110
        -3= 1111 1111 1111 1111 1111 1111 1111 1101
        -4= 1111 1111 1111 1111 1111 1111 1111 1100
        -5= 1111 1111 1111 1111 1111 1111 1111 1011
        -6= 1111 1111 1111 1111 1111 1111 1111 1010        
        -7= 1111 1111 1111 1111 1111 1111 1111 1001
        */
        n = -20;
        System.out.println(Integer.toBinaryString(n));
        
        System.out.println("#".repeat(80));
        
        /*
        1111 1111 1111 1111 1111 1111 1111 1011
        1111 1111 1111 1111 1111 1111 1111 1101
        -3
        0111 1111 1111 1111 1111 1111 1111 1101
        2147483646
        */
        
        n = -5;
        System.out.println(Integer.toBinaryString(n));
        n >>= 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
        n = -5;
        n >>>= 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println(n);
    }
    
    public static void main(String[] args) {
        int in = 1234;
        countBits(in);
//        code0();
        code1();
    }
}
