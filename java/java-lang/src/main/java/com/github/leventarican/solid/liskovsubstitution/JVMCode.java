package com.github.leventarican.solid.liskovsubstitution;

/**
 * @author levent
 */
public class JVMCode implements Code {
    private String lang = "java";

    public JVMCode(String lang) {
        this.lang = lang;
    }
    
    @Override
    public String language() {
        return lang;
    }
    
}
