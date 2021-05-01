//https://www.codewars.com/kata/55685cd7ad70877c23000102/train/java
//https://www.codewars.com/kata/56676e8fabd2d1ff3000000c/train/java
//https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/train/java
//https://www.codewars.com/kata/576bb71bbbcf0951d5000044/train/java

package com.github.leventarican.dojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Katas {

    public static int makeNegative(final int x) {
        var a = x > 0 ? x * -1 : x;
        System.out.println(a);
        return a;
    }

    public static String findNeedle(Object[] haystack) {
        var a = Arrays.asList(haystack).indexOf("needle");
        System.out.println(a);
        return "found the needle at position " + a;
    }

    public static String abbrevName(String name) {
        String[] a = name.toUpperCase().split(" ");
        return a[0].charAt(0) + "." + a[1].charAt(0);
    }

    //return an array with count of positives and sum of negatives
    public static int[] countPositivesSumNegatives(int[] input) {
        if ((input == null) || (input.length == 0)) return new int[] {};
//        IntStream.of(input).filter(i -> i>0).reduce((a,b) -> a+b).ifPresent(System.out::println);
        var s = IntStream.of(input).collect(StringBuilder::new,
                StringBuilder::append, 
                StringBuilder::append).toString();
        System.out.println(s);
        var count = IntStream.of(input)
                .filter(i -> i>0)
                .count();
        var sum = IntStream.of(input)
                .filter(i -> i<0)
                .sum();
        System.out.println(count + "; " + sum);
        return new int[] {(int)count, sum};
    }

    // https://www.codewars.com/kata/57cc981a58da9e302a000214/train/java
    static boolean smallEnough(int[] a, int limit) {
        boolean s0 = Arrays.stream(a).noneMatch(i -> i > limit);
        boolean s1 = IntStream.of(a).noneMatch(i -> i > limit);
        System.out.println("0. with streams: " + s0);
        System.out.println("1. with streams: " + s1);
        
        // classic way
        for (int i=0; i<a.length; i++) {
            if (a[i] > limit) {
                return false;
            }
        }
        return true;
    }
    
    // https://www.codewars.com/kata/54ff0d1f355cfd20e60001fc/train/java
    static int factorial(int n) throws IllegalArgumentException {
        
        // corner case
        if (n < 0 || n > 12)
            throw new IllegalArgumentException();
        
        int f = 1;
        for (int i = 1; i < n; i++) {
            f = f * (i+1);
        }
        System.out.println("factorial " + n + " -> " + f);
        return f;
    }
    
    // https://www.codewars.com/kata/554e4a2f232cdd87d9000038/train/java
    static String makeComplement(String dna) {
        
        String a = Arrays.stream(dna.split(""))
                .map(s -> s.equals("T")?"A" : s.equals("A")?"T" : s.equals("G")?"C" : s.equals("C")?"G" : "#")
                .collect(Collectors.joining());
        System.out.println(a);
        
        return "";
    }
    
    static void factorial1(int n) {
        // n! = 1 * 2 * ... * n
        int result = 1;
        for (int i=1; i<=n; i++) {
            result *= i;
        }
        System.out.println("factorial of " + n + " = " + result);
    }
    
    static void factortial2(int start, int end, int n) {
        System.out.println(String.format("factorial (recursive) s=%d; e=%d; n=%d", start, end, n));
        if (start < end) {
            factortial2(++start, end, start*n);
        }
    }
    
    static void positiveSum(int[] n) {
        int sum = 0;
        for (int i=0; i<n.length; i++) {
            sum += n[i]>0 ? n[i] : 0;
        }
        System.out.println("sum: " + sum);
    }
    
    /*
    a prime number (or a prime) 
    is a natural number greater than 1 
    that has no positive divisors other than 1 and itself.
    */
    static boolean isPrime(int n) {
        if (n > 1) {
            for (int i=2; i<n; i++) {
                if (n%i == 0) {
                    System.out.println(n + " is NOT a prime.");
                    return false;
                }
            }
        }
        System.out.println(n + " is a prime.");
        return true;
    }
    
    // https://www.codewars.com/kata/525e5a1cb735154b320002c8/train/java
    static int tringular(int n) {
        int dots = 0;
        for (int i=0; i<=n; i++) {
            dots += i;
        }
        System.out.println(dots);
        return dots;
    }
    
    // https://www.codewars.com/kata/5700c9acc1555755be00027e/train/java
    static boolean rotations(String s, List<String> a) {        
        StringBuilder b = new StringBuilder(s);
        for (int i=0; i<s.length(); i++) {
            b.insert(0, b.charAt(b.length()-1));
            b.delete(b.length()-1, b.length());
            String r = b.toString();
            System.out.println(r);
            
            if (!a.contains(r)) {
                System.out.println("array doesn't contain all rotations");
                return false;
            }
        }
        return true;
    }
    /*
    return IntStream.range(0, strng.length())
            .mapToObj(i -> strng.substring(i) + strng.substring(0, i))
            .allMatch(arr::contains);
    */
    
    
    // https://www.codewars.com/kata/5526fc09a1bbd946250002dc/train/java
    /*
    [2, 4, 0, 100, 4, 11, 2602, 36]
    Should return: 11 (the only odd number)
    */
    static int parityOutlier(int[] n) {
        /*
        1. find number of odds
        2. find number of evens
        compare which is bigger
        the lower should be exactly once.
        */
        
        // corner case
        if (n.length < 3) {
            return 0;
        }

        int o = 0;
        int e = 0;
        for (int i=0; i<n.length; i++) {
            if ((n[i] % 2) != 0) {
                o++;
            } else {
                e++;
            }
        }
        
        System.out.println("o: " + o + "; e: " + e);
        
        if (o == 1) {
            for (int i=0; i<n.length; i++) {
                if ((n[i] % 2) != 0) {
                    System.out.println("o: " + n[i]);
                    return n[i];
                }
            }
        } else if (e == 1) {
            for (int i=0; i<n.length; i++) {
                if ((n[i] % 2) == 0) {
                    System.out.println("e: " + n[i]);
                    return n[i];
                }
            }
        }
        
        // O(2n)
        
        return 0;
    }
    /*
    int[] odd = Arrays.stream(integers).filter(n -> n % 2 != 0).toArray();
    int[] even = Arrays.stream(integers).filter(n -> n % 2 == 0).toArray();
    return odd.length == 1 ? odd[0] : even[0];
    */
    
    // https://www.codewars.com/kata/5659c6d896bc135c4c00021e/train/java
    /*
    nextSmaller(21) == 12
    nextSmaller(531) == 513
    nextSmaller(2071) == 2017
    */
    static long nextSmaller(long n) {
        /*
        0. iterate reverse and compare if all numbers contained
        1. corner cases: duplicates number e.g. 900
        */
        
        System.out.println("# INPUT: " + n);
        
        if (n < 0) {
            return -1L;
        }
        
        List<String> a = List.of(String.valueOf(n).split(""));
        System.out.println(a);
        
        for (long i=n-1; i>0; i--) {
            
            System.out.println(i);
            
            if (i < n-100) {
                return -1L;
            }
            
            String[] b = String.valueOf(i).split("");
            
            // corner case: e.g. 111
            if (a.size() != b.length) {
                System.out.println("# RETURN -1");
                return -1L;
            }
            
            List<String> c = new ArrayList<>();
            for (String bb : b) {
                c.add(bb);
            }
            
            if (c.containsAll(a)) {
                System.out.println("CONTAINS");
                return -1L;
                // corner case: 441
//                for (String aa : a) {
//                    if (c.contains(aa)) {
//                        c.remove(aa);
//                    }
//                }
//                if (c.isEmpty()) {
//                    
//                    // corner case: skip 0
//                    if (b[0].equals("0")) {
//                        System.out.println("# RETURN -1");
//                        return -1L;
//                    }
//                    
//                    System.out.println("# RETURN " + i);
//                    return i;
//                }
            }
        }
        
        // O(n²)
        
        System.out.println("# RETURN -1");
        return -1L;
    }
    
    static long nextSmallerEnhanced(long n) {
        String[] a = String.valueOf(n).split("");
        String[] backup = a.clone();
        
        for (long i=n-1; i>0; i--) {
            String[] b = String.valueOf(i).split("");
            
            if (b.length < a.length) {
                System.out.println("# NOTHING FOUND; BREAK ");
                return -1L;
            }
            
            // 531 -> 513
            for (int j = 0; j<a.length; j++) {
                for (int k = 0; k<b.length; k++) {
                    if (a[j].equals(b[k])) {
                        a[j] = "";
                        b[k] = "";
                    }
                }
            }
            a = backup.clone();

            String c = String.join("", b);
            if (c.isEmpty()) {
                System.out.println("# FOUND " + i);
                return i;
            }
        }
        
        System.out.println("# NOTHING FOUND ");
        return -1L;
    }
    
    static long nextSmallerEnhanced1(long n) {
        String[] a = String.valueOf(n).split("");
        String[] backup = a.clone();
        
        for (long i=n-1; i>0; i--) {
//            String s = String.valueOf(i);
            String s = Long.toString(i);
            
            if (n - (n-100) == i) {
                return -1L;
            }
            
            if (s.length() < a.length) {
                System.out.println("# NOTHING FOUND; BREAK ");
                return -1L;
            }

//            String[] b = s.split("");
//            String[] b = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "1"};
            String[] b = new String[s.length()];
            for (int t = 0; t < b.length; t++) {
                char c = s.charAt(t);
                b[t] = Character.toString(c);
            }
            
            a = backup.clone();
            boolean skip = false;
            
            for (int j = 0; j<a.length; j++) {
                for (int k = 0; k<b.length; k++) {
                    if (a[j].equals(b[k])) {
                        a[j] = "";
                        b[k] = "";
                    }
                }
                if (!a[j].equals("")) {
                    skip = true;
                    break;
                }
            }

            if (!skip) {
                String c = String.join("", b);
                if (c.isEmpty()) {
                    System.out.println("# FOUND " + i);
                    return i;
                }
            }
        }
        
        System.out.println("# NOTHING FOUND ");
        return -1L;
    }
    
    static long nextSmallerEnhanced2(long n) {
        String[] a = String.valueOf(n).split("");
        String[] backup = a.clone();
        
        // corner case: equal number. e.g. 111
        boolean skip = true;
        for (int j = 0; j<a.length; j++) {
            if (!a[0].equals(a[j])) {
                skip = false;
            }
        }
        if (skip) {
            System.out.println("# NOTHING FOUND; CORNER CASE");
            return -1L;
        }
        
        for (long i=n-1; i>0; i--) {
            String s = Long.toString(i);
            
            if (s.length() < a.length) {
                System.out.println("# NOTHING FOUND; BREAK ");
                return -1L;
            }

            String[] b = new String[s.length()];
            for (int t = 0; t < b.length; t++) {
                char c = s.charAt(t);
                b[t] = Character.toString(c);
            }
            
            a = backup.clone();
            skip = false;
            
            for (int j = 0; j<a.length; j++) {
                for (int k = 0; k<b.length; k++) {
                    if (a[j].equals(b[k])) {
                        a[j] = "";
                        b[k] = "";
                    }
                }
                if (!a[j].equals("")) {
                    skip = true;
                    break;
                }
            }

            if (!skip) {
                String c = String.join("", b);
                if (c.isEmpty()) {
                    System.out.println("# FOUND " + i);
                    return i;
                }
            }
        }
        
        System.out.println("# NOTHING FOUND ");
        return -1L;
    }
    
    static void code1() {
//        long a = 123456789;
//        String[] b = String.valueOf(a).split("");
//        long c = 123456739;
//        String[] d = String.valueOf(c).split("");
        
        // we assume strings must have same length
//        for (int i=0; i<b.length; i++) {
//            for (int j=0; j<d.length; j++) {
//                if (b[i].equals(d[j])) {
//                    System.out.println("####");
//                    d[i] = "";
//                }
//            }
//        }
  

        long a = 123456789;
        long b = 123456739;
        String c = String.valueOf(a);
        String[] d = String.valueOf(b).split("");
        
        for (int i=0; i<d.length; i++) {
            if (c.charAt(i) == d[i].charAt(0)) {
                d[i] = "";
            }
        }
        
        System.out.println("#");
        for (String z : d) {
            System.out.print(z);
        }
        System.out.println("##");
        
        // O(n²)
    }
    
    static void code0() {
        long a = 123456789;
        List<String> b = List.of(String.valueOf(a).split(""));
        
        long c = 123456739;
        String[] d = String.valueOf(c).split("");
        List<String> e = new ArrayList<>();
        for (String s : d) {
            e.add(s);
        }
        
        /*
        iterate 123456789
        1 in 123456739 ? 
        2 in 123456739 ? 
        ...
        8 in 123456739 ? --> FALSE
        ...
        */
        for (String s : d) {
            System.out.println("#" + e.contains(s));
            e.remove(s);
        }
    }
 
    static long nextSmallerEnhanced4(long n) {
        Collection<String> uniques = new HashSet<>();
        Collection<String> duplicates = new ArrayList<>();
        
        for (String s : String.valueOf(n).split("")) {
            if (!uniques.add(s)) {
                duplicates.add(s);
            }
        }
        
        Collection<String> duplicatesCopy = new ArrayList<>(duplicates);
  
        duplicates.forEach( z -> System.out.print(z));
        System.out.println("#");
        uniques.forEach( z -> System.out.print(z));
        System.out.println("##");
        
        for (long i=n-1; i>0; i--) {
            Collection<String> u = new HashSet<>();
            Collection<String> d = new ArrayList<>();            
            for (String s : String.valueOf(i).split("")) {
                if (!u.add(s)) {
                    d.add(s);
                }
            }
            
//            d.forEach( z -> System.out.print(z));
//            u.forEach( z -> System.out.print(z));
//            System.out.println("#");
            
            if ((uniques.size()+duplicates.size()) != (u.size()+d.size())) {
                return -1L;
            }
            
            duplicates.removeAll(d);
            uniques.removeAll(u);
            
            if ((duplicates.isEmpty()) && (uniques.isEmpty())) {
                
                // re-init
                duplicates.clear();
                uniques.clear();
                for (String s : String.valueOf(n).split("")) {
                    if (!uniques.add(s)) {
                        duplicates.add(s);
                    }
                }
                
                if (duplicates.size() == d.size()) {                 
                    duplicates.forEach( x -> d.remove(x));
                    if (d.isEmpty()) {
                        System.out.println("# FOUND " + i);
                        return i;
                    }                   
                }
            }
            
            /*
            15755354873198872
            15755354873198827
            15755354873198852
            */
            
            // re-init
            duplicates.clear();
            uniques.clear();
            for (String s : String.valueOf(n).split("")) {
                if (!uniques.add(s)) {
                    duplicates.add(s);
                }
            }
        }
        
        return -1L;
    }
    
    static long nextSmallerEnhanced3(long n) {
//        Collection<String> a = new ArrayList<String>();
//        Collection<String> da = new LinkedHashSet<>();
//        for (String s : String.valueOf(n).split("")) {
//            a.add(s);
//        }
//        
//        for (long i=n-1; i>0; i--) {
//            Collection<String> b = new ArrayList<String>();
//            for (String s : String.valueOf(i).split("")) {
//                b.add(s);
//            }
//            
//            a.removeAll(b);
//            System.out.println("# " + i);
//            System.out.println(a.size());
//            a.clear();
//            for (String s : String.valueOf(n).split("")) {
//                a.add(s);
//            }
//        }
        
        return -1L;
    }
    
    static long nextSmallerEnhanced5(long n) {
        Map<String, Integer> a = new HashMap<>();
        a.put("0", 0);
        a.put("1", 0);
        a.put("2", 0);
        a.put("3", 0);
        a.put("4", 0);
        a.put("5", 0);
        a.put("6", 0);
        a.put("7", 0);
        a.put("8", 0);
        a.put("9", 0);
        for (String s : String.valueOf(n).split("")) {
            if (a.containsKey(s)) {
                a.put(s, a.get(s) + 1);
            }
        }
        
//        a.values().forEach(System.out::println);

        for (long i=n-1; i>0; i--) {
            Map<String, Integer> b = new HashMap<>();
            b.put("0", 0);
            b.put("1", 0);
            b.put("2", 0);
            b.put("3", 0);
            b.put("4", 0);
            b.put("5", 0);
            b.put("6", 0);
            b.put("7", 0);
            b.put("8", 0);
            b.put("9", 0);
            for (String s : String.valueOf(i).split("")) {
                b.put(s, b.get(s) + 1);
//                b.values().forEach(System.out::print);
//                System.out.println("");
            }
        }
        
        return -1L;
    }
    
    public static void main(String[] args) {
        makeNegative(-42);
        makeNegative(42);

        Object[] haystack1 = {"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false};
        findNeedle(haystack1);

        abbrevName("Sam Harris");
        
        int[] expectedResult = new int[] {8, -50};
        int[] input = new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14};
        countPositivesSumNegatives(input);
        
        System.out.println("expected: true --> " + smallEnough(new int[] {66, 101}, 200));
        
        factorial(5);
        
        makeComplement("GTAT");
        
        factorial1(5);
        
        factortial2(1, 5, 1);
        
        positiveSum(new int[] {1, -4, 3, 4});
        
        isPrime(73);
        
        tringular(1275);
        
        List<String> a = Arrays.asList("abc", "cab", "bca");
        rotations("abc", a);
        
//        parityOutlier(new int[] {2, 4, 0, 100, 4, 11, 2602, 36});
        parityOutlier(new int[] {2, -6, 8, -10, -3});
        
//        nextSmaller(441);
//        nextSmaller(907);
//        nextSmaller(55);
//        nextSmaller(1027);
        
        // 21.308 s
//        nextSmaller(123456789);
//        123456739
        
//        code0();
//        code1();
        long difficult = 123456789;
        long y = 123456798;
//        nextSmallerEnhanced(difficult);
//        nextSmallerEnhanced2(9999999999L);
//        nextSmallerEnhanced2(1023456789);
//        nextSmallerEnhanced(907);
//        nextSmallerEnhanced4(920607841);
//        nextSmallerEnhanced5(12345678999L);
        nextSmallerEnhanced5(122345678L);
    }
}
