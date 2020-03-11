package com.github.leventarican.cdijavase;

import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * CDI for Java SE.
 * 
 * @since CDI 2.0
 * @author Levent
 */
public class Main {
    
    public static void main(String[] args) {
        // SeContainer (Weld SE container) is auto-closeable
        // disable auto-discovery. beans are set manually. no need for beans.xml.
        try (var cdiContainer = SeContainerInitializer.newInstance().disableDiscovery()
                .addBeanClasses(MainService.class, App.class, TimeService.class)
                .initialize()) {
            
            var service = cdiContainer.select(MainService.class).get();
            for (int i = 0; i < 3; i++) {
                System.out.println(Main.class.getSimpleName() + ": " + service.getData());
            }
            
            var app = cdiContainer.select(App.class).get();
            app.exec();
        }
    }
}
