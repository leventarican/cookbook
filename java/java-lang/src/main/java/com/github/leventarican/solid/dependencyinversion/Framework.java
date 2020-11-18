package com.github.leventarican.solid.dependencyinversion;

/**
 *
 * @author levent
 */
public class Framework {
    final private String description;

    public Framework(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
}
