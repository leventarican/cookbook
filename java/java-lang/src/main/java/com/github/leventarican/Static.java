package com.github.leventarican;

/**
 * @author levent
 */
public class Static {
    public static void main(String[] args) {
        new Java7();
        var packages = Java7.getPackages();
        System.out.println(packages);
        // 210
        System.out.println(Java7.CODENAME);
        // Dolpin
    }
}

class Java7 {

    static final String VERSION = "1.7.0";
    static final String CODENAME;
    static int PACKAGES = 209;

    static {
        CODENAME = "Dolphin";
    }
    
    public Java7() {
        PACKAGES++;
    }

    static int getPackages() {
        return PACKAGES;
    }

}
