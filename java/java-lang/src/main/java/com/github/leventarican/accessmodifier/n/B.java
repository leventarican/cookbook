package com.github.leventarican.accessmodifier.n;

/**
 * @author levent
 */
public class B {
    public static void main(String[] args) {
        A a = new A();
        System.out.println("B can use A. Same package. Except private method.");
        // a.privateExample();
        a.defaultExample();
        a.protectedExample();
    }
}
