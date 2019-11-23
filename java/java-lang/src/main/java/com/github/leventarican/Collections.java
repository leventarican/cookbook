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
        
        int[] numbers = {1, 200, 3, 40};
        
//        Arrays.sort(numbers, (x,y) -> {
//            return x.compareTo(y);
//        });
        
        for (String programmingLanguage : programmingLanguages) {
            System.out.println(programmingLanguage);
        }
    }
    
    void generic() {
//        Generics sind nicht kovariant, sie sind invariant. 
        Number x = Integer.valueOf(3);
        Number y = Double.valueOf(3.3);
        
//        Typ Double[] ist vom Typ Number[]: das nennt sich kovariant.
        Number[] numbers = new Double[2];
//        numbers[0] = 3;
        numbers[1] = 3.3;
        
//        wildcard typ ?: ein unbekannter typ
        Computer<Java> j = new Java(10);
    }
    
    public static void main(String[] args) {
        var app = new Collections();
        app.filter();
        app.generic();
    }
}

/**
 * excursion in generics
 * 
 * ?: Wildcard-Typ
 * ? extends Typ: Upper-bounded Wildcard-Typ
 * ? super Typ: Lower-bounded Wildcard-Typ
 */

class Computer<T extends ProgrammingLanguage> {
    private T value;
    public Computer(T value) {
        this.value = value;
    }
    public T get() {
        return this.value;
    }
}

class ProgrammingLanguage {
    private int id;
    public ProgrammingLanguage(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}

class Java extends ProgrammingLanguage {
    public Java(int id) {
        super(id);
    }
}

class Kotlin extends Java {
    public Kotlin(int id) {
        super(id);
    }
}