package com.github.leventarican.accessmodifier.n;

/**
 * @author levent
 */
public class C extends A {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("C can use A. Same package. Except private method.");
        // a.privateExample();
        a.defaultExample();
        a.protectedExample();
    }
}
