package com.github.leventarican;

/**
 * we have a shared object/value/data; threads (context switch)
 * 
 * @author levent
 */
public class RaceCondition {
    
    // atomic
    private int n;
    
    class Shared implements Runnable {
        
        /*synchronized*/ void increment() {
            n++;
        }
        
        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + "; n = " + n);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
            increment();
        }
        
    }
        
    private void code() {
        Thread t0 = new Thread(new Shared(), "thread 0");
        Thread t1 = new Thread(new Shared(), "thread 1");
        Thread t2 = new Thread(new Shared(), "thread 2");
        
        t0.start();
        t1.start();
        t2.start();
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        
        System.out.println("n = " + n);
    }
    
    public static void main(String[] args) {
        RaceCondition rc = new RaceCondition();
        rc.code();
    }
}
