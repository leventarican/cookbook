package com.github.leventarican.code2019.day1;

/**
 * @author Levent
 */
public class Main {
    
    /*
    For a mass of 12, divide by 3 and round down to get 4, then subtract 2 to get 2.
    For a mass of 14, dividing by 3 and rounding down still yields 4, so the fuel required is also 2.
    For a mass of 1969, the fuel required is 654.
    For a mass of 100756, the fuel required is 33583.
    */
    
    // fuel for a module = roundDown(mass / 3) - 2
    int calculateFuelForModule(int mass) {
        int result = (int) Math.floor(mass / 3) - 2;
        System.out.println(result);
        return result;
    }
    
    void solution() {
        int[] input = {12, 14, 1969, 100756};
        for (int i : input) {
            calculateFuelForModule(i);
        }
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.solution();
    }
}
