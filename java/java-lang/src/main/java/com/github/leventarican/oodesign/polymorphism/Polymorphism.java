package com.github.leventarican.oodesign.polymorphism;

import java.util.List;

/**
 * @author levent
 */
public class Polymorphism {

    void code() {
        System.out.println("Polymorphism in Action");
    }
    
    public static void main(String[] args) {
        List<Polymorphism> data = List.of(new A(), new A(), new B());
        data.forEach((Polymorphism p) -> p.code());
    }
}

class A extends Polymorphism {}
class B extends Polymorphism {}