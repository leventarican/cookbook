package com.github.leventarican.code2018.day1;

import java.util.stream.Stream;

/**
 * @author Levent
 */
public class Main {
    
    String[] input = {
        "+1, +1, +1",   // results in  3
        "+1, +1, -2",   // results in  0
        "-1, -2, -3"    // results in -6
    };
    
    void solution() {
        var result = Stream.of(input[2].split(","))
                .map(String::strip)
                .map(Integer::valueOf)
                .mapToInt( x -> x)
                .sum();
        System.out.println("result: " + result);
    }
    
    public static void main(String[] args) {
        var main = new Main();
        main.solution();
    }
}
