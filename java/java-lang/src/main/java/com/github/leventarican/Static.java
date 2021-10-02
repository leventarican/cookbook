package com.github.leventarican;

/**
 * What is the output?
 * 
 * @author levent
 */
public class Static {
    public static void main(String[] args) {
        
        System.out.println(Java7.getPackages());
        System.out.println(Java7.CODENAME);
        
        new Java7();
        new Java7();
        new Java7();
        
        System.out.println(Java7.getPackages());
    }
}

class Java7 {

    static final String VERSION = "1.7.0";
    static final String CODENAME;
    static int PACKAGES = 209;

    static {
        CODENAME = "Dolphin";
        System.out.println("static block: " + CODENAME);
    }
    
    public Java7() {
        PACKAGES++;
    }

    static int getPackages() {
        return PACKAGES;
    }

}
