package com.github.leventarican;

import java.nio.charset.StandardCharsets;

/**
 * bits := binary digits
 * 
 * boolean 1 bit
 * byte    8 bits
 * char    16 bits
 * short   16 bits
 * int     32 bits
 * long    64 bits
 * float   32 bits
 * double  64 bits
 */
public class BitsBytes {
    static void exec() {
        System.out.println("\nBits and Bytes:");

        System.out.println("0b0000_0001: " + 0b00000001);
        System.out.println("0b0000_0010: " + 0b00000010);
        System.out.println("0b0000_0100: " + 0b00000100);
        System.out.println("0xf: " + 0xf);
        System.out.println("16: " + Integer.toBinaryString(16));
        System.out.println("4: " + Integer.toBinaryString(4));

        byte[] bytes = "foobar".getBytes(StandardCharsets.UTF_8);
        System.out.print("foobar: ");
        for (byte aByte : bytes) {
            System.out.print(Integer.toHexString(aByte));
//            ASCII: 0x66: f, 0x6f: o, 0x62: b, 0x61: a, 0x72: r
        }
        System.out.println();
        
        System.out.println("8 bits: " + 0b0111_1111);
        System.out.println("8 bits: " + 0b1000_0000);
        
        int min_32bit = 0b10000000_00000000_00000000_00000000;  // Integer.MIN_VALUE = -2147483648
        int max_32bit = 0b01111111_11111111_11111111_11111111;  // Integer.MAX_VALUE = 2147483647
        int max_int = Integer.MAX_VALUE;
        System.out.println("int max value: " + max_int);
        
        int mask = 0b10000000_00000000_00000000_00000000;
        int example_int = 16;
        System.out.println("masked: " + (example_int & 0b1110_1111) );
        
        // before shift: 0b01111111_11111111_11111111_11111111
        // after shift:  0b00000000_00000000_00000000_01111111
        System.out.println("mask and shift: " + (max_32bit >> 24) );
        dtype(max_32bit >> 24);
    }
    
    static void dtype(int x) {
        System.out.println("int: " + x);
    }
    static void dtype(long x) {
        System.out.println("long: " + x);
    }
    
    static void operators() {
        // 0000 0011
        byte eight = 3;
        // invert (unary bitwise complement operator): 1111 1100
        byte guesswhat = ~3;
        System.out.println(eight);
        System.out.println(guesswhat);
        
        // 0000 0100
        byte a = 4;
        // 0000 0101
        byte b = 5;
        // 0000 0100
        System.out.println(a & b);
    }
    
    static void wise_shift() {
        int mask = 0x0F;
        int val = 0xFF;
        System.out.println(val & mask);
    }
    
    public static void main(String[] args) {
        exec();
        operators();
        wise_shift();
    }
}
