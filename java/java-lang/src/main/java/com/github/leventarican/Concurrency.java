package com.github.leventarican;

public class Concurrency {
    public void exec() {
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new CountDown());
        // who will win the race?
        t1.start();
        t2.start();
        new CountTwo().start();
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
