package com.github.leventarican.dojo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/59c633e7dcc4053512000073/train/java
 *
 * @author levent
 */
public class Kata7 {

    /*
    solve("zodiacs") = 26
    1. cross out vowels "aeiou"
    2. z = 26, d = 4 and cs = 3 + 19 = 22
    3. highest z = 26
    
    a = 1, b = 2, c = 3, .... z = 26
    */
    static int solve(final String s) {
        
        /*
        a 1
        e 5
        i 9
        o 15
        u 21
        
        String vowels = "aeiou";
        int[] skip = new int[vowels.length()];
        for (int i = 0; i < skip.length; i++) {
            skip[i] = vowels.codePointAt(i) - 96;
        }
        for (int i = 0; i < skip.length; i++) {
            System.out.println("# " + skip[i]);
        }
        */
        
        String[] a = s.split("");
        List<Integer> b = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            int d = a[i].codePointAt(0) - 96;
            if (d != 1 && d != 5 && d!= 9 && d != 15 && d != 21) {
                c += d;
            } else {
                b.add(c);
                c = 0;
            }
        }
        b.add(c);
        
        int max = 0;
        for (int i : b) {
            System.out.println("# " + i);
            if (i > max) {
                max = i;
            }
        }
        
        System.out.println("max: " + max);
        
        return max;
    }
    /*
    int sum = 0, maxsum = 0;
    char[] arr = s.toCharArray();
    for (char c : arr) {
        if ("aeiou".indexOf(c)>=0) sum = 0;
        else {
            sum += c-'a'+1;
            maxsum = Math.max(sum, maxsum);
        }
    }
    return maxsum;
    
    return of(s.split("[aeiou]")).mapToInt(con -> con.chars().map(c -> c - 96).sum()).max().orElse(0);
    */

    public static void main(String[] args) {
        String a = "zodiacs";
        String b = "chruschtschov";
        solve(b);
    }
}
