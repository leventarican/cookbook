package com.github.leventarican;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

/**
 * @author levent
 */
@Dependent
public class ProgrammingLanguage {
    
    @Inject
    @ConfigProperty(name = "java")
    String version;
    
    public String version() {
        return this.version;
    }
}
