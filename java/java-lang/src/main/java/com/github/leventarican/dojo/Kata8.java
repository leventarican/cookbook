package com.github.leventarican.dojo;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codewars.com/kata/556deca17c58da83c00002db/train/java
 * https://www.codewars.com/kata/57ed30dde7728215300005fa/train/java
 * https://www.codewars.com/kata/585d7d5adb20cf33cb000235/train/java
 *
 * @author levent
 */
public class Kata8 {

    static double[] tribonacci(double[] s, int n) {
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            if (i < s.length) {
                a[i] = s[i];
            } else {
                a[i] = 0.0;
            }
        }

        for (int i = s.length; i < n; i++) {
            double b = a[i - 1] + a[i - 2] + a[i - 3];
            System.out.println("b " + b);
            a[i] = b;
        }

        for (Double d : a) {
            System.out.println(d);
        }
        System.out.println("");

        return a;
    }

    /*
    double[] r = new double[n];
    for(int i = 0; i < n; i++){
      r[i] = (i<3)?s[i]:r[i-3]+r[i-2]+r[i-1];
    }
    return r;
    
    Stream.iterate(s, p -> new double[]{p[1], p[2], p[0] + p[1] + p[2]}).limit(n).mapToDouble(p -> p[0]).toArray();
     */
    static String bumps(final String road) {
        int bumps = 0;
        char[] a = road.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 'n') {
                bumps++;
            }
        }
        String solution = bumps > 15 ? "Car Dead" : "Woohoo!";
        System.out.println(solution);
        return solution;
    }

    /*
    return road.chars().filter(c -> c =='n').count() > 15 ? "Car Dead" : "Woohoo!";
    return road.replace("_", "").length() > 15 ? "Car Dead" : "Woohoo!";
     */
    
    static double findUniq(double arr[]) {
        double u = 0.0;
        List<Double> skip = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            double a = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (a == arr[j]) {
                    if (!skip.contains(a)) {
                        skip.add(a);
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            double a = arr[i];
            if (!skip.contains(a)) {
                u = a;
            }
        }

        System.out.println(u);

        return u;
    }
    /*
    Arrays.sort(arr);
    return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    */

    public static void main(String[] args) {
        tribonacci(new double[]{1, 1, 1}, 10);
        bumps("_nnnnnnn_n__n______nn__nn_nnn");
        findUniq(new double[]{0, 1, 0});
    }
}
