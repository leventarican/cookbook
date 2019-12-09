package com.github.leventarican.code2019.day3;

import java.util.Map;
import java.util.stream.IntStream;

/**
 * Find the intersection point closest to the central port.
 * 
 * What is the Manhattan distance from the central port to the closest intersection?
 * 
 * @author Levent
 */
public class Main {
    
    String line_0 = "R8,U5,L5,D3";
    String line_1 = "U7,R6,D4,L4";
    
    String[][] coordinate = new String[32][32];
    
    void taxicabDistance() {
        
    }
    
    void solution() {
        
    }
    
    void draw() {
        var o = new Pair(16,16);
        var directions = line_0.split(",");
        for (String direction : directions) {
            var distance = Integer.valueOf(String.valueOf(direction.charAt(1)));
            System.out.println(distance);
            switch (direction.charAt(0)) {
                case 'R':
                    System.out.println("RIGHT (+x,y)");
                    IntStream.range(0, distance).forEach((x) -> { 
                        o.x++;
                        coordinate[o.y][o.x] = "-"; 
                    });
                    break;
                case 'L':
                    System.out.println("LEFT (-x,y)");
                    for (var x = distance; x > 0; x--) {
                        o.x--;
                        coordinate[o.y][o.x] = "-";
                    }
                    break;
                case 'U':
                    System.out.println("UP (x,y-)");
                    for (var y = distance; y > 0; y--) {
                        o.y--;
                        coordinate[o.y][o.x] = "|";
                    }
                    break;
                case 'D':
                    System.out.println("DOWN (x,y+)");
                    IntStream.range(0, distance).forEach((y) -> { 
                        o.y++;
                        coordinate[o.y][o.x] = "|"; 
                    });
                    break;
            }
        }
    }
    
    void init() {
        for (int y = 0; y < coordinate.length; y++) {
            for (int x = 0; x < coordinate[0].length; x++) {
                coordinate[y][x] = ".";
            }
        }
    }
    
    void display() {
        for (int y = 0; y < coordinate.length; y++) {
            System.out.println("");
            for (int x = 0; x < coordinate[0].length; x++) {
                System.out.print(coordinate[y][x]);
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        var app = new Main();
        app.init();
        app.draw();
        app.display();
        app.solution();
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}