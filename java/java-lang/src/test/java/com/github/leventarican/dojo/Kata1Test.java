package com.github.leventarican.dojo;

import static org.junit.Assert.*;
import org.junit.Test;

public class Kata1Test {

    @Test
    public void testSomething1() {
        assertEquals(true, Kata1.getXO("xxxooo"));
    }

    @Test
    public void testSomething2() {
        assertEquals(true, Kata1.getXO("xxxXooOo"));
    }

    @Test
    public void testSomething3() {
        assertEquals(false, Kata1.getXO("xxx23424esdsfvxXXOOooo"));
    }

    @Test
    public void testSomething4() {
        assertEquals(false, Kata1.getXO("xXxxoewrcoOoo"));
    }

    @Test
    public void testSomething5() {
        assertEquals(false, Kata1.getXO("XxxxooO"));
    }

    @Test
    public void testSomething6() {
        assertEquals(true, Kata1.getXO("zssddd"));
    }

    @Test
    public void testSomething7() {
        assertEquals(false, Kata1.getXO("Xxxxertr34"));
    }

}
