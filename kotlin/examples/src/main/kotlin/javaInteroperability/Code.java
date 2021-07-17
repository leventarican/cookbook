package javaInteroperability;

import objectOrientedProgramming.Data;
import objectOrientedProgramming.DataJava;
import objectOrientedProgramming.Java;
import staticFunctions.ExampleKt;
import staticFunctions.JavaStyle;

/**
 * For interoperability demonstration: java <-> kotlin
 */
public class Code {
    public static void main(String[] args) {
        System.out.println("java code");

        ExampleKt.packageLevel();
        JavaStyle.Companion.staticFunction();
        JavaStyle.javaFriendly();

        var d = new Data("hello from java to kotlin");
        System.out.println(d.toString());

        var dj = new DataJava("hello from java to java");
        System.out.println(dj.toString());
    }
}
