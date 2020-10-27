/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.leventarican.dojo;

import java.util.Arrays;

/**
 * from codewars
 *
 * @author levent
 */
public class Kata1 {

    /*
    XO("ooxx") => true
    XO("xooxx") => false
    XO("ooxXm") => true
    XO("zpzpzpp") => true // when no 'x' and 'o' is present should return true
    XO("zzoo") => false
     */
    public static boolean getXO(String str) {
        
        int o = Arrays.stream(str.split(""))
                .mapToInt((String value) -> value.equalsIgnoreCase("o")? 1 : 0)
                .sum();
        int x = Arrays.stream(str.split(""))
                .mapToInt((String value) -> value.equalsIgnoreCase("x")? 1 : 0)
                .sum();
        
        return o == x;
    }
}

// checkout also clever solution: just remove the chars and then compare.
//str = str.toLowerCase();
//return str.replace("o","").length() == str.replace("x","").length();
