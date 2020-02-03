package com.github.leventarican;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Concurrency {
    public void exec() {
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new CountDown());
        // who will win the race?
        t1.start();
        t2.start();
        new CountTwo().start();
        
        System.out.println("multithreaded app with a threapool.");
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.schedule(new Task("task-0"), 3, TimeUnit.SECONDS);
        executor.schedule(new Task("task-1"), 4, TimeUnit.SECONDS);
        executor.schedule(new Task("task-2"), 5, TimeUnit.SECONDS);
        System.out.println("3 task scheduled.");
        executor.shutdown();
    }

    class CountTwo extends Thread {
        @Override public void run() {
            super.run();
            for (int i = 0; i < 10; i=i+2) {
                System.out.println("CountTwo: " + i);
            }
        }
    }
    class Counter implements Runnable {
        @Override public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Counter: " + i);
            }
        }
    }
    class CountDown implements Runnable {
        @Override public void run() {
            for (int i = 10; i > 0; i--) {
                System.out.println("CountDown: " + i);
            }
        }
    }
}
