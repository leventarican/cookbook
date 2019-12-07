package com.github.leventarican.guessinggame;

import java.util.Scanner;

/**
 * inspired by http://www.brendangregg.com/guessinggame.html
 * 
 * @author Levent
 */
public class Main {
    
    // TODO: write to file
    
    void run() {
        var randomNumber = (int) (Math.random() * 10);
        System.out.println("guess the number from 0 to 10");
        
        var scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            var input = scanner.next();
            if (String.valueOf(randomNumber).equals(input)) {
                System.out.println("correct.");
            } else {
                System.out.println("wrong.");
            }
        }
        System.out.println("end.");
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.run();
    }
}
