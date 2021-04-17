package com.github.leventarican.performance;

/**
 * @author levent
 */
public class StandardOptimization {
    
    // move loop invariant computation out of the loop
    static void loop() {
        int[] digits = {100, 20, 500};
        
        // not good
        for (int i=0; i<digits.length*2; i++) {
            System.out.println(i + ". statement");
        }
        
        // better
        for (int i=0, stop=digits.length*2; i<stop; i++) {
            System.out.println(i + ". statement");
        }
    }
    
    // reduce array index access
    static void access() {
        int n = 3;
        int m = 3;
        
        int[][] arr = {
            {10, 20, 30},
            {50, 40, 90},
            {70, 80, 0}
        };
        
        int[] sum = new int[n];
        
        // not good
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sum[i] += arr[i][j];
            }
        }
        
        // better
        for (int i=0; i<n; i++) {
            // e.g. {10, 20, 30},
            int[] ai = arr[i];
            int s = 0;
            for (int j=0; j<m; j++) {
                s += ai[j];
            }
            sum[i] = s;
        }
        
        for (int i=0; i<n; i++) {
            System.out.println(sum[i]);
        }
    }
    
    public static void main(String[] args) {
        loop();
        access();
    }
}
