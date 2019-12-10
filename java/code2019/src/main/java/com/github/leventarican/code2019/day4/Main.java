package com.github.leventarican.code2019.day4;

/**
 * @author Levent
 */
public class Main {
    
    String a = "122345";
    
    void draft() {
        var meets_criteria = true;
        var numbers = a.chars()
                .map(c -> Character.getNumericValue(c))
                .toArray();
        for (int i = 0; i+1 < numbers.length;) {
            var current = numbers[i++];
            var next = numbers[i];
            if (current > next) {
                meets_criteria = false;
                break;
            }
        }
        System.out.println("meet criteria: " + meets_criteria);
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.draft();
    }
}
