package com.github.leventarican;

import java.util.StringTokenizer;

/**
 *
 * @author levent
 */
public class UnderConstruction {
    
    public static void main(String[] args) {
        StringTokenizer tokenizer = new StringTokenizer("java|is|a|oop|language.", "|");
        while (tokenizer.hasMoreElements()) {
            String next = (String) tokenizer.nextElement();
            System.out.println(next);
        }
        
        Runnable r = () -> {
            System.out.println("");
        };
    }
}
