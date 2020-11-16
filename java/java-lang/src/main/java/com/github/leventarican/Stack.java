package com.github.leventarican;

/**
 * LIFO: last in first out data structure.
 *
 * @author levent
 */
public class Stack {

    public static void main(String[] args) {
        withJavaUtilStack();
        withOwnImplementation();
    }

    static void withJavaUtilStack() {
        java.util.Stack data = new java.util.Stack();
        data.push("data-0");
        data.push("data-1");
        data.push("data-2");
        System.out.println(data.pop());
        System.out.println(data.pop());
        System.out.println(data.pop());
    }

    static class StackImpl {
        int index = 0;
        String[] data = new String[3];

        void push(String value) {
            data[index++] = value;
        }
        
        void pop() {
            var value = data[--index];
            System.out.println(value);
        }
        
        void displayIndex() {
            System.out.println(index);
        }
    }

    static void withOwnImplementation() {
        var a = new StackImpl();
        a.push("java");
        a.push("kotlin");
        a.displayIndex();
        a.pop();
        a.displayIndex();
        
        var b = new Stack.StackImpl();
        b.displayIndex();
        b.push("scala");
        b.displayIndex();
        b.pop();
    }

}
