package com.github.leventarican;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class BitsBytes {
    public void exec() {
        System.out.println("\nBits and Bytes:");

        System.out.println("0b0000001: " + 0b0000001);
        System.out.println("0b0000001: " + 0b0000010);
        System.out.println("0b0000001: " + 0b0000100);
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
    }
}
