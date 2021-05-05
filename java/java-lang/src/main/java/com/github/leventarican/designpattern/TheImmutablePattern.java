package com.github.leventarican.designpattern;

/**
 * Set Once; then Read-Only.
 * Famous example is the {@link String} object.
 * @author Levent
 */
public class TheImmutablePattern {

    private String programmingLang;
    private boolean isJVMcompatibale;
    
    public TheImmutablePattern(String programmingLang) {
        this.programmingLang = programmingLang;
        if (this.programmingLang.equals("java") || this.programmingLang.equals("kotlin"))
            isJVMcompatibale = true;
    }
    
    /**
     * @return read-only programming language.
     */
    public String getProgrammingLang() {
        return programmingLang;
    }
    
    public boolean isJVMcomptabile() {
        return isJVMcompatibale;
    }
    
    public static void main(String[] args) {
        TheImmutablePattern im = new TheImmutablePattern("python");
        im.getProgrammingLang();
        System.out.println(im.isJVMcomptabile());
    }
}
