package com.github.leventarican.code2019.day3;

import java.util.stream.IntStream;

/**
 * Find the intersection point closest to the central port.
 * 
 * What is the Manhattan distance from the central port to the closest intersection?
 * 
 * @author Levent
 */
public class Main {
    
    String path_0 = "R8,U5,L5,D3";
    String path_1 = "U7,R6,D4,L4";
    String path_2 = "R75,D30,R83,U83,L12,D49,R71,U7,L72";
    String path_3 = "U62,R66,U55,R34,D71,R55,D58,R83";
    String path_4 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51";
    String path_5 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7";
    
    int map_size = (int) Math.pow(2.0, 9.0);
    int start_position = map_size / 2;
    
    int taxicabDistance(int[][] map_0, int[][] map_1) {
        for (int y = 0; y < map_0.length; y++) {
//            System.out.println("");
            for (int x = 0; x < map_0[0].length; x++) {
                map_0[y][x] = map_0[y][x] & map_1[y][x];
//                System.out.print(map_0[y][x]);
            }
        }
        
        for (int y = start_position; y > 0; y--) {
            var values = map_0[y];
            for (int x = start_position; x < values.length; x++) {
                var value = values[x];
                if (value == 1) {
                    var x_steps = x-start_position;
                    var y_steps = start_position-y;
                    System.out.println("\n" + x_steps + " + " + y_steps);
                    return x_steps + y_steps;
                }
            }
        }
        
        return -1;
    }
    
    int[][] map(String path) {
        int[] pos = {start_position,start_position};
        int[][] coordinate = new int[map_size][map_size];
        coordinate[pos[0]][pos[1]] = 9;
        var directions = path.split(",");
        for (String direction : directions) {
            var steps = Integer.valueOf(direction.substring(1));
            switch (direction.charAt(0)) {
                case 'R':
                    IntStream.range(0, steps).forEach((x) -> { 
                        pos[1]++;
                        coordinate[pos[0]][pos[1]] = 1;
                    });
                    break;
                case 'L':
                    for (var x = steps; x > 0; x--) {
                        pos[1]--;
                        coordinate[pos[0]][pos[1]] = 1;
                    }
                    break;
                case 'U':
                    for (var y = steps; y > 0; y--) {
                        pos[0]--;
                        coordinate[pos[0]][pos[1]] = 1;
                    }
                    break;
                case 'D':
                    IntStream.range(0, steps).forEach((y) -> { 
                        pos[0]++;
                        coordinate[pos[0]][pos[1]] = 1; 
                    });
                    break;
            }
        }
        return coordinate;
    }
    
    public static void main(String[] args) {
        var app = new Main();
        var map_0 = app.map(app.path_2);
        var map_1 = app.map(app.path_3);
        var distance = app.taxicabDistance(map_0, map_1);
        System.out.println("solution: " + distance);
    }
}
