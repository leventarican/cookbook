package com.github.leventarican.solid.dependencyinversion;

/**
 * dependency inversion principle: a class is not responsible for creating
 * instances of their dependencies.
 *
 * @author levent
 */
public class ExampleA {

    public static void main(String[] args) {
        var dev = new Developer(new Framework(("quarkus")));
        dev.code();
    }
}

class Developer {

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

class Framework {

    final private String description;

    public Framework(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
