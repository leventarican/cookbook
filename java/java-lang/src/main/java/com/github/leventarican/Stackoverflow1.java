package com.github.leventarican;

/**
 * @author levent
 */
public class Stackoverflow1 {
    
    public void force(int i) {
        force(i);
//        System.out.println(i);
    }
    
    public static void main(String[] args) {
        var stack = new Stackoverflow1();
        stack.force(1);
    }
}
