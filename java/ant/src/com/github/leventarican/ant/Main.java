package com.github.leventarican.ant;

import org.apache.log4j.Logger;

public class Main {
    private final static Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        System.out.println("###");

        for (int i=0; i<args.length; i++) {
            System.out.println("arg-" + i + ": " + args[i]);
        }

        log.info("Apache Log4j");
    }
}