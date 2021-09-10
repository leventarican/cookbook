package com.github.leventarican;

/**
 * @author levent
 */
public class Constants {
        
    public static void main(String[] args) {        
        // final variable reference
        var data = new Data();
        data.payload = "1111";
        final var reference = new Data();
        // cannot change reference
        // reference = data;
        reference.payload = "0000";
        System.out.println(data.payload);
        System.out.println(reference.payload);
        
        // we cant change content and length of the string
        String immutable = "hello";
        // here we can manipulate the string
        StringBuffer mutable = new StringBuffer("hello");
        mutable.append(" world");
        System.out.println(mutable);
        
        final var immutableInt = 100;
    }
}

// cannot be extended
final class Data {
    String payload = "0101";
}
