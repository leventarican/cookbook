package com.github.leventarican.network;

/**
 *
 * @author levent
 */
public class App {
    public static void main(String[] args) {
        Developer[] developers = Hub.getDevelopers();
        for (Developer developer : developers) {
            System.out.println(developer);
        }
    }
}
