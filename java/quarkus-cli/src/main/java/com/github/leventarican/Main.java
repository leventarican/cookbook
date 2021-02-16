package com.github.leventarican;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import javax.inject.Inject;
import org.jboss.logging.Logger;

/**
 * @author levent
 */
@QuarkusMain
public class Main implements QuarkusApplication {
    
    private static final Logger LOG = Logger.getLogger(Main.class);
    
    @Inject
    ProgrammingLanguage java;

    @Override
    public int run(String... args) throws Exception {
        var msg = "Java version: " + this.java.version();
        LOG.debug(msg);
        LOG.info("shutdown now.");
        return 100;
    }
}
