package com.github.leventarican;

import java.lang.reflect.Method;

/**
 * access class object with getClass()
 * 
 * @author levent
 */
public class Clazz {
   
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

}
