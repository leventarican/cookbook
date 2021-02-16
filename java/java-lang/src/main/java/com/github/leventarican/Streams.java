package com.github.leventarican;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * hands-on java.util.stream
 * 
 * @author Levent
 */
public class Streams {
    void line() {
        var line = IntStream.range(0, 80)
                .mapToObj(i -> "#")
                .collect(Collectors.joining());
        System.out.println(line);
    }
    
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
        
        line();
        
        String []string= "java java kotlin java".split(" ");
        Arrays.stream(string)
                .distinct()
                .forEach(System.out::println);
    }
    
    void search() {
        line();
        
        var firstValue = IntStream.of(4, 9, 100, 30)
                .findFirst()
                .orElse(-1);
        System.out.println("first value: " + firstValue);
        
        var sortedFirstValue = IntStream.of(400, 9, 100, 30)
                .sorted()
                .findFirst()
                .orElse(-1);
        System.out.println("sorted first value: " + sortedFirstValue);
        
        var match100 = IntStream.of(400, 9, 100, 30)
                .anyMatch(i -> i == 100);
        System.out.println("match 100: " + match100);
        
        var allMatch100 = IntStream.of(400, 9, 100, 30)
                .allMatch(i -> i == 100);
        System.out.println("all match 100: " + allMatch100);
    }
    
    // do operations parallel: each operation is done in a cpu core
    void parallelism0() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        System.out.println(list);
        var a = list.parallelStream()
                .mapToInt(i -> i)
                .sum();
        System.out.println(a);
    }
    
    void parallelism1() {
        List<Integer> list = Arrays.asList(1,2,3,4);
        list.parallelStream()
                .map(Code::process)
                .forEach(i -> System.out.println(i));
    }
    
    static class Code {
        static Integer process(Integer i) {
            return i + 100;
        }
    }
    
    public static void main(String[] args) {
        var app = new Streams();
//        app.code();
//        app.search();
//        app.parallelism0();
        app.parallelism1();
    }
}
