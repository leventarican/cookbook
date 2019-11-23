package com.github.leventarican;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Java Collections: fundamental data structures.
 * 
 * Cover newer approach introduces with Java 8:
 * Streams API and Lambda Expressions.
 * 
 * Because of the history java syntax can't be such concise as kotlin, ...
 * 
 * @author Levent
 */
public class Collections {
    
    void filter() {
        String[] input = {"java", "kotlin", "Java", "c++"};
        var programmingLanguages = Arrays.asList(input);
        var result = programmingLanguages.stream()
                .filter(pl -> pl.equalsIgnoreCase("java"))
                .collect(Collectors.joining(";"));
        
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        var app = new Collections();
        app.filter();
    }
}
