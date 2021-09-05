package com.github.leventarican.accessmodifier.m;

import com.github.leventarican.accessmodifier.n.A;

/**
 * Demonstration of protected:
 * 
 * With protected we declare only sub classes have access to protected 
 * from a different package.
 * 
 * @author levent
 */
public class Z extends A {
    public static void main(String[] args) {
        A a = new A();
        // non of these works
//        a.privateExample();
//        a.defaultExample();
//        a.protectedExample();

        Z z = new Z();
        // can only access protected.
//        z.privateExample();
//        z.defaultExample();
        z.protectedExample();
    }
}
