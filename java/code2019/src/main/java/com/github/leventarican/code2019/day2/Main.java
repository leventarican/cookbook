package com.github.leventarican.code2019.day2;

import java.util.Arrays;

/**
 * @author Levent
 */
public class Main {

    /*
    intcode_example[0]: opcode 1 (addition)
    intcode_example[1]: position of first summand
    intcode_example[2]: position of second summand
    intcode_example[3]: position of where to store result
    intcode_example[4]: opcode 99 (program finished)
    */
    int[] intcode_example = {1,0,0,3,99};
    
    /*
     1: add numbers of two positions and store result in a third position
     2: like 1. except add do a multiply
    99: program finished
    anything else: unknown code
    */
    int[] opcodes = {1, 2, 99};
    
    void solution() {
        var opcode = intcode_example[0];
        var position_1 = intcode_example[1];
        var position_2 = intcode_example[2];
        var position_3 = intcode_example[3];
        switch (opcode) {
            case 1:
                intcode_example[position_3] = intcode_example[position_1] + intcode_example[position_2];
                break;
            case 2:
                intcode_example[position_3] = intcode_example[position_1] * intcode_example[position_2];
                break;
            case 99:
                break;
        }
        for (int i : intcode_example) {
            System.out.print(i + ",");
        }
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.solution();
    }
}
