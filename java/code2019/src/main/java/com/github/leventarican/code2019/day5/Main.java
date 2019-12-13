package com.github.leventarican.code2019.day5;

import java.util.stream.Stream;

/**
 * two more instruction: opcode 3 (input) and 4 (output)
 * parameter-mode defines how to handle parameters
 *  0: position mode (default; position == address)
 *  1: immediate mode (value)
 * 
 * @author Levent
 */
public class Main {

    /*
    intcode_example[0]: opcode 1 (addition), opcode 2 (multiply)
    intcode_example[1]: position of first summand
    intcode_example[2]: position of second summand
    intcode_example[3]: position of where to store result
    intcode_example[4]: opcode 99 (program finished)
    */
    int[] intcode_example = {1,0,0,3,99};
    
    String input = "1002,4,3,4,33";
    
    /*
     1: add numbers of two positions and store result in a third position
     2: like 1. except add do a multiply
    99: program finished
    anything else: unknown code
    */
    int[] opcodes = {1, 2, 99};
    
    void solution_() {
//        var result = Stream.of(input.split(","))
//                .mapToInt(s -> Integer.valueOf(s))
//                .filter(i-> i>1000)
//                .sum();

        Stream.of(input.split(","))
                .mapToInt(s -> Integer.valueOf(s))
                .forEach(i -> {
                    if (i >= 100) {
                        separateModeOpcode(i);
                    }
                });
    }
    
    // calculate in base 10 (= decimal); 2 digits are opcode
    void separateModeOpcode(int value) {
        int mode = value;
        for (int i = 0; i < 2; i++) {
            mode /= 10;
        }
        System.out.println("mode: " + mode);
        
        int factor = 1;
        for (int i = 0; i < 2; i++) {
            factor *= 10;
        }
        System.out.println("opcode: " + (value - mode * factor));
    }
    
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
            case 3:
                break;
            case 4:
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
        app.solution_();
    }
}
