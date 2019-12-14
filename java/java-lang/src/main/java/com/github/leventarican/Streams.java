package com.github.leventarican;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * hands-on java.util.stream
 * 
 * @author Levent
 */
public class Streams {
    void code() {
        // we have an array
        String[] data = { "java", "kotlin", "c++" };
        
        // now we want do some operations on it
        // do operation 3 times, sort and print out
        IntStream.range(0, 3)
                .forEach( (i) -> 
                        Stream.of(data).sorted().forEach( (s) -> System.out.println(s) )
                );
        
        // reverse sort
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.stream()
            .sorted(java.util.Collections.reverseOrder())
            .forEach(System.out::println);
        
        // int to array
        int i = 1234;
        int[] digits = Integer.toString(i).chars().map(c -> c-'0').toArray();
    }
    
    public static void main(String[] args) {
        var app = new Streams();
        app.code();
    }
}
