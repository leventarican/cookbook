package com.github.leventarican.dojo;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/59377c53e66267c8f6000027/train/java
 * 
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
    
    static String alphabetWar(String fight) {
        
        int left = 0;
        int right = 0;
        
        char[] a = fight.toCharArray();
        for (int i = 0; i < a.length; i++) {
            switch(a[i]) {
                case 'w':
                    left += 4;
                    break;
                case 'p':
                    left += 3;
                    break;
                case 'b':
                    left += 2;
                    break;
                case 's':
                    left += 1;
                    break;
                case 'm':
                    right += 4;
                    break;
                case 'q':
                    right += 3;
                    break;
                case 'd':
                    right += 2;
                    break;
                case 'z':
                    right += 1;
                    break;
            }
        }
        
        System.out.println("left " + left + " vs right " + right);
        
        if (left == right) {
            return "Let's fight again!";
        }
        
        return left > right ? "Left side wins!" : "Right side wins!";
    }
    
    public static void main(String[] args) {
        countCharacters("aaaaaaaabbbbbbc");
        alphabetWar("zdqmwpbs");
    }
}
