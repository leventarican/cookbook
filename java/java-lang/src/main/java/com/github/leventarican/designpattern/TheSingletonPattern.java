package com.github.leventarican.designpattern;

/**
 * Singleton pattern used on enum
 */
public enum TheSingletonPattern {
    INSTANCE;
    public String kotlin() { return "kotlin"; }
    public String kotlinVersion() { return "v 1.3.0"; }
    public String java() { return "java"; }
    public String javaVersion() { return "v 12"; }
}
