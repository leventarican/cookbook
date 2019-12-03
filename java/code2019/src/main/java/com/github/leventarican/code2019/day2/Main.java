package com.github.leventarican.code2019.day2;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Levent
 */
public class Main {

    /*
    intcode_example[0]: opcode 1 (addition)
    intcode_example[1]: position 0 (first summand)
    intcode_example[2]: position 0 (secont summand)
    intcode_example[3]: position 3 (store result here)
    intcode_example[4]: opcode 99 (program finished)
    */
    int[] intcode_example = {1,0,0,3,99};
    
    /*
     1: add numbers of two positions and store result in a third position
     2: like 1. except add do a multiply
    99: program finished
    anything else: unknown code
    */
    int[] opcode = {1, 2, 99};
    
    void solution() {
        Arrays.stream(intcode_example)
                .forEach((i) -> {
                    switch(i) {
                        case 1: 
                            System.out.println(i + "; opcode 1 found");
                            break;
                        case 99: System.out.println(i + "; opcode 99 found");
                    }
                });
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.solution();
    }
}
