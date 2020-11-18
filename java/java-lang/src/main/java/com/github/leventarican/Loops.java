package com.github.leventarican;

import java.util.stream.IntStream;

public class Loops {

    public static void main(String[] args) {
        do {
            System.out.println("reachable");
        } while (true == false);

        int c = 0;
        while (c > 0) {
            // unreachable
        }

        for (int i = 0; i != 2; i++) {
            System.out.println("i: " + i);
        }

        // enhanced for-loop
        for (int i : IntStream.range(0, 2).toArray()) {
            System.out.println("i: " + i);
        }
    }
}
