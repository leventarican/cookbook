package com.github.leventarican.accessmodifier.n;

/**
 * Who can access?
 * 
 * See class n.B, n.C and class m.Z
 * 
 * @author levent
 */
public class A {
    private void privateExample() {
        System.out.println("access modifier: private");
    }
    void defaultExample() {
        System.out.println("access modifier: default, friendly, package private");
    }
    protected void protectedExample() {
        System.out.println("access modifier: protected");
    }
}
