package com.github.leventarican;

public class Loops {

    public void exec() {
        System.out.println("\nLoops:");

        do {
            System.out.println("reachable");
        } while (true == false);

        int c = 0;
        while(c > 0) {
            // unreachable
        }

        for (int i=0; i!=2; i++) {
            System.out.println("i:" + i);
        }
        /*
        i:0
        i:1
        */
    }
}
