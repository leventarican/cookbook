package com.github.leventarican.dojo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/51e0007c1f9378fa810002a9/train/java
 * 
 * @author levent
 */
public class Kata4 {
    
    /*        
    i increments the value (initially 0)
    d decrements the value
    s squares the value
    o outputs the value into the return array
    */
    static int[] parse(String data) {
        int value = 0;
        List<Integer> a = new ArrayList();
        String[] d = data.split("");
        for (int i = 0; i < data.length(); i++) {
            switch (d[i]) {
                case "i":
                    value++;
                    break;
                case "d":
                    value--;
                    break;
                case "s":
                    value *= value;
                    break;
                case "o":
                    a.add(value);
                    break;
                default:
                    break;
            }
        }
        int[] b = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            b[i] = a.get(i);
        }
        for (int n : b) {
            System.out.println(n);
        }
        return b;
    }
    /*
    int[] b = new int[data.replaceAll("[^o]","").length()]; 
    */
    
    public static void main(String[] args) {
        String[] data = new String[] {"iiisdoso"};
        parse(data[0]);
    }
}
