package com.github.leventarican.cdijavase;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;

/**
 * @author Levent
 */
@ApplicationScoped
public class MainService {
    public String getData() {
        return MainService.class.getSimpleName() + ": " + new Random().nextInt(10);
    }
}
