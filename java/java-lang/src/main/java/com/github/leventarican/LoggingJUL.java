package com.github.leventarican;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Logging with java.util.logging (JUL).
 * @since Java 1.4
 */
public class LoggingJUL {

    private static final Logger log = Logger.getLogger(LoggingJUL.class.getName());

    public void exec() {
        configuration();

        log.info("simple demo of Logging-API (JSR-47)");

        try {
            ((Object)null).toString();
        } catch(Exception e) {
            // same as log.severe() ...
            log.log(Level.SEVERE, "you tried null to String", e);
        }

        log.info("no problem we catch'ed that error.");
    }

    void configuration() {
        // -Djava.util.logging.config.file=logging.properties
        System.setProperty("java.util.logging.config.file", "logging.properties");
        try {
            LogManager.getLogManager().readConfiguration();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
