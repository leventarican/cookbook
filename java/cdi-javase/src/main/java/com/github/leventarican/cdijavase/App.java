package com.github.leventarican.cdijavase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @author Levent
 */
@ApplicationScoped
public class App {
    
    @Inject
    TimeService service;
    
    public void exec() {
        System.out.println(App.class.getSimpleName() + ": " + service.getCurrentTime());
    }
}
