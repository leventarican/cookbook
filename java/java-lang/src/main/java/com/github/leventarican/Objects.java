package com.github.leventarican;

import java.util.ArrayList;

public class Objects {

    String field0 = "every objects is based on class Object.";

    // we don't need to create a default constructor
    // the compiler will do that for us.
    Objects() {}

    // so called copy-constructor
    Objects(String field0) {
        this.field0 = field0;
    }

    void exec() throws InterruptedException {
        // raw strings in java 12
//        String rStr = `Objects
//        * create
//        * destroy objects
//        `;
        System.out.println("Objects: create, destroy, memory leaks");

        // reference a will be cleared from GC (garbage collector) after leaving scope
        {
            new Objects();
            Objects obj = new Objects();
        }

        // mark that there is no more reference to the object
        // the GC will delete the object
        {
            Objects obj = new Objects();
            obj = null;
        }
    }
}
