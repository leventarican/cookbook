package com.github.leventarican.code2019.day4;

import java.util.stream.IntStream;

/**
 * How many different passwords meet the criteria?
 * 
 * @author Levent
 */
public class Main {
    
    String[] input = {
        "122345",
        "111111",
        "111123",
        "223450",
        "123789",
        "1237789"
    };
    
    boolean solution(String password) {
        if (password.length() != 6) {
            return false;
        }
        var numbers = password.chars()
                .map(c -> Character.getNumericValue(c))
                .toArray();
        for (int i = 0; i+1 < numbers.length;) {
            var current = numbers[i++];
            var next = numbers[i];
            if (current > next) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        var app = new Main();
        var result = IntStream.range(0, app.input.length)
                .filter(i -> app.solution(app.input[i]))
                .count();
        System.out.println(result);
    }
}
