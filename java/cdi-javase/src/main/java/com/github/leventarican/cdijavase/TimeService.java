package com.github.leventarican.cdijavase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.enterprise.context.ApplicationScoped;

/**
 * If you want to use @RequestScoped then: https://stackoverflow.com/a/26632111
 * It runs in another Thread.
 * 
 * @author Levent
 */
@ApplicationScoped
public class TimeService {
    public String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd.MM.yyyy"));
    }
}
