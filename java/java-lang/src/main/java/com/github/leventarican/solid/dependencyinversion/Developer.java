package com.github.leventarican.solid.dependencyinversion;

/**
 * dependency inversion principle: a class is not responsible for creating
 * instances of their dependencies.
 *
 * @author levent
 */
public class Developer {

    // better if we inject this dependency OR an interface
    private Framework framework;

    public Developer(Framework framework) {
        this.framework = framework;
    }
    
    public void code() {
        var code = String.format("coding with framework: %s", framework.getDescription());
        System.out.println(code);
    }
}
