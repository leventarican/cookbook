package com.github.leventarican.dojo;

/**
 * from codewars
 *
 * @author levent
 */
public class Kata0 {

    /*
    highAndLow("1 2 3 4 5")  // return "5 1"
    highAndLow("1 2 -3 4 5") // return "5 -3"
    highAndLow("1 9 3 4 -5") // return "9 -5"
     */
    public static String highAndLow(String numbers) {
        // https://de.wikipedia.org/wiki/Bubblesort
        String[] a = numbers.split(" ");
        for (int i = a.length; i > 1; i--) {
            // process from left to right
            for (int j = 0; j < i - 1; ++j) {
                if (Integer.parseInt(a[j]) > Integer.parseInt(a[j + 1])) {
                    String t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                }
            }
        }
        return String.format("%s %s", a[a.length - 1], a[0]);
    }
}
