package com.github.leventarican;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * no more casting.
 * 
 * 
 * generics naming conventions:
 * E - Element (used extensively by the Java Collections Framework)
 * K - Key
 * N - Number
 * T - Type
 * V - Value
 * S,U,V etc. - 2nd, 3rd, 4th types
 * https://docs.oracle.com/javase/tutorial/java/generics/types.html
 * 
 * @author Levent
 */
public class Generics {
    
    class GenericClass0 <T> {
    }
    class GenericClass1 <T extends Object> {
        // same as: GenericClass0 <T>
    }
    class ProgrammingLanguage<T> {
        private T field;
        public ProgrammingLanguage() {}
        public ProgrammingLanguage(T field) {
            this.field = field;
        }
        @Override
        public String toString() {
            return field.toString();
        }
    }
    class Java {
        @Override
        public String toString() {
            var name = "Java.";
            System.out.println(name);
            return name;
        }
    }
    class Kotlin {
        @Override
        public String toString() {
            var name = "Kotlin.";
            System.out.println(name);
            return name;
        }
    }
    
    class GenericNumber <T extends Number> {
        T field;
        public GenericNumber(T field) {
            this.field = field;
        }
        public void print() {
            String value = String.valueOf(field) + 0b1100100;
            System.out.println(value);
        }
    }
    
    class Box<T> {}
    
    // bound (restrict) types
    <T extends Number> List<T> bounding(T[] a) {
        // ...
        return null;
    }
    
    void diamond() {
        Generics.Box<Integer> box;
        box = new Box<Integer>();
        box = null;
        // with diamond operator; its an integer compiler can infer the type
        box = new Box<>();
        System.out.println(box);
    }
    
    public static void main(String[] args) {
        var app = new Generics();

        var java = app.new ProgrammingLanguage<Java>(app.new Java());
        System.out.println(java);
        var kotlin = app.new ProgrammingLanguage<Kotlin>(app.new Kotlin());
        System.out.println(kotlin);
        
        app.diamond();
        
        Generics.GenericNumber<Integer> i = app.new GenericNumber<>(7);
        i.print();
        Generics.GenericNumber<Float> f = app.new GenericNumber<>(7.0f);
        f.print();
        
    }
}