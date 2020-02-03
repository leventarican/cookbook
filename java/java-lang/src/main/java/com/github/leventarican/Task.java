package com.github.leventarican;

/**
 * @author Levent
 */
public class Task implements Runnable {
    private final String name;
    
    public Task(String name) {
        this.name = name;
    }
    
    @Override
    public void run() {
        try {
            System.out.println("# Task.run: " + name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
