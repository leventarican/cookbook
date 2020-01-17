package com.github.leventarican.simple;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author Levent
 */
public class MainNGTest {
    
    public MainNGTest() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = {
            "Junit", "TestNG"
        };
        Main.main(args);
    }
    
}
