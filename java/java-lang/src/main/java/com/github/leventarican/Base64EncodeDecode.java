package com.github.leventarican;

import java.util.Base64;

/**
 * @author Levent
 */
public class Base64EncodeDecode {
    
    void code() {
        var encoded = Base64.getEncoder().encodeToString("java".getBytes());
        var decoded = new String(Base64.getDecoder().decode(encoded));
        
        System.out.println(String.format("encoded: %s; decoded: %s", encoded, decoded));
    }
    
    public static void main(String[] args) {
        var app = new Base64EncodeDecode();
        app.code();
    }
}
