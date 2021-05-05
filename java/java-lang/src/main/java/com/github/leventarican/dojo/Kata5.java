package com.github.leventarican.dojo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author levent
 */
public class Kata5 {
    
    static void countCharacters(String s) {
        String[] a = s.split("");
        Map<String, Integer> b = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            int value = 1;
            if (b.containsKey(key)) {
                value = b.get(key) + 1;
            }
            b.put(key, value);
        }
        
        // output
        b.entrySet().forEach(e -> {
            System.out.println(e.getKey() + ";" + e.getValue());
        });
    }
    
    public static void main(String[] args) {
        countCharacters("aaaaaaaabbbbbbc");
    }
}
