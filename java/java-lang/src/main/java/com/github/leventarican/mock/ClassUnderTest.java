package com.github.leventarican.mock;

/**
 * a class for unit testing with a dependency.
 *
 * @author Levent
 */
public class ClassUnderTest {

    private DependenyClass dc;

    public void init(DependenyClass dc) {
        this.dc = dc;
    }

    public String ping() {
        if (dc.debug()) {
            System.out.println("pong");
        }
        return "pong";
    }
}
