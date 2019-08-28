package com.github.leventarican.mock;

/**
 * a class for unit testing with a dependency.
 *
 * @author Levent
 */
public class ClassUnderTest {

    private DependenyClass dc;
    private SpyClass sc;

    public ClassUnderTest() {
        this.dc = new DependenyClass();
        this.sc = new SpyClass();
    }

    public String ping() {
        if (dc.debug()) {
            System.out.println("ClassUnderTest - DEBUG: " + dc.debug());
        }
        return "pong";
    }
}
