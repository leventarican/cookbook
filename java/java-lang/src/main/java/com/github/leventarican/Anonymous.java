package com.github.leventarican;

/**
 * @author levent
 */
public class Anonymous {
    private String data;
    
    Anonymous(A a) {
        this.data = a.code("example payload");
        System.out.println("2. A data => " + data);
    }
    
    public static void main(String[] args) {
        var a = new Anonymous(new A() {
            @Override
            public String salt() {
                return "salting";
            }
        });
        System.out.println(a.data);
    }
}

interface A {
    public default String code(String payload) {
        System.out.println("1. a default impl.");
        return "data:" + payload;
    }
    public String salt();
}