package com.github.leventarican;

import java.lang.reflect.Method;

/**
 * access class object with getClass()
 * 
 * @author levent
 */
public class Clazz {
    
    // field declaration with modifiers
    // if no access modifier given then the access modifier is protected by default
    @Deprecated
    int a = 0, b = 1, c = 2;
    // defined in class only; rather then each instance of class.
    static int d = 100;
    // once initialized never changed
    final int f = 200;
    
    // see Serialization class for an example
    transient int t = 300;
    
    // for concurrency; on access the value must be reread from memory.
    volatile int v = 400;
   
    // prevent instantiating; protected class
    Clazz() {
        System.out.println("\nClass:");
        
        Method[] m = getClass().getMethods();
        for (Method method : m) {
            System.out.println("method: " + method);
        }

        class LocalClass {
            LocalClass() {
                System.out.println("inner class: " + getClass().getSimpleName());
            }
        }

        Runnable anonymousClass = new Runnable() {
            @Override
            public void run() {
                System.out.println("inner class: anonymous");
            }
        };

        new LocalClass();
        anonymousClass.run();
    }

    static class StaticClass {
        static void whoami() {
            System.out.println("inner class: " + StaticClass.class.getSimpleName());
        }
    }

    class MemberClass {
        MemberClass() {
            System.out.println("inner class: " + getClass().getSimpleName());
        }
    }
    
    public static void main(String[] args) {
        var app = new Clazz();
        System.out.println(app.d);
        System.out.println(Clazz.d);
    }

}
