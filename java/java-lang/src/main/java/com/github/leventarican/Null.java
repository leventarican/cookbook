package com.github.leventarican;

import java.util.Optional;

/**
 * Optional, NullPointerException, null
 * 
 * @author Levent
 */
public class Null {
    public static void main(String[] args) {
        Null app = new Null();
        app.versionUnsafe();
        app.versionSafe();
    }
    
    void versionSafe() {
        Computer c = new Computer();
        String v = c.safeCard.orElse(new GraphicCard()).safeUSB.orElse(new USB()).getVersion();
        System.out.println("version: " + v);
    }
    
    void versionUnsafe() {
        Computer c = new Computer();
        try {
            String v = c.card.usb.getVersion();
            System.out.println("version: " + v);
        } catch (NullPointerException e) {
            System.err.println(e + " # use Optionals");
        }
    }
    
    class Computer {
        GraphicCard card;
        Optional<GraphicCard> safeCard = Optional.empty();
    }
    class GraphicCard {
        USB usb;
        Optional<USB> safeUSB = Optional.empty();
    }
    class USB {
        String getVersion() {
            return "0.0.1";
        }
    }
}
