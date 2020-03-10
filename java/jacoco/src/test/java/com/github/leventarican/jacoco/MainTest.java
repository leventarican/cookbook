package com.github.leventarican.jacoco;

import org.junit.Before;
import org.junit.Test;

public class MainTest {
    
    private Main cut;
    
    @Before
    public void init() {
        cut = new Main();
    }
    
    @Test
    public void testHello() {
        String actual = cut.hello("JaCoCo");
        org.junit.Assert.assertEquals("hello JaCoCo", actual);
    }
}
