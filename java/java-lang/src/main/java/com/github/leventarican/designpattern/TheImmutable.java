package com.github.leventarican.designpattern;

/**
 * Set Once; then Read-Only.
 * @author Levent
 */
public class TheImmutable {

    private String programmingLang;
    
    public TheImmutable(String programmingLang) {
        this.programmingLang = programmingLang;
    }
    
    /**
     * @return read-only programming language.
     */
    public String getProgrammingLang() {
        return programmingLang;
    }
}
