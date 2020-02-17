package com.github.leventarican;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java Collections: fundamental data structures.
 * 
 * Cover newer approach introduces with Java 8:
 * Streams API and Lambda Expressions.
 * 
 * Because of the history java syntax can't be such concise as kotlin, ...
 * 
 * Collection: List / Set
 * Map: SortedMap / WeakHashMap / Hashtable / HashMap
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
    
    void handson() {
        // Collection<E>: <E> the type of elements in this collection
        Collection<Integer> c = Arrays.asList(7, 4, 900, 7, 4, 0);
        int max = c.stream().flatMapToInt( x -> {
            return IntStream.of(x);
        }).distinct().max().getAsInt();
        System.out.println(max);
        
        var min = Arrays.asList("java", "kotlin", "c", "c++")
                .stream()
                .map( x -> { return x.length(); })
                .mapToInt(m -> m)
                .min()
                .getAsInt();
        System.out.println(min);
        
        var s = "JAVA";
        var codepoints = s.codePoints();
//        codepoints.forEach(System.out::println);
    }

    void generateAtoZ() {
        var start = 65; // A
        var end = start + 26;    // alphabet has 26 letters
        var box = IntStream.builder();
        IntStream.range(start, end).forEach((value) -> {
            box.add(value);
        });
        var atoz = new StringWriter();
        box.build().forEach(atoz::write);
        System.out.println(atoz);   // ABCDEFGHIJKLMNOPQRSTUVWXYZ
    }
    
    /**
     * make foobar to barfoo.
     */
    void reverse() {
        List<String> letters = new ArrayList<>();
        letters.add("f");
        letters.add("o");
        letters.add("o");
        letters.add("b");
        letters.add("a");
        letters.add("r");
        
        for (String s : letters) {
            System.out.print(s);
        }
        
        java.util.Collections.rotate(letters, 3);

        String result = String.join("", letters);
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        var app = new Collections();
        app.filter();
        app.handson();
        app.generateAtoZ();
        app.reverse();
    }
}
