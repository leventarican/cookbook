package com.github.leventarican.mock;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author Leven
 */
public class ClassUnderTestTest {
    
    ClassUnderTest cut;
    
    @Mock
    DependenyClass dc;
    
    @Before
    public void init() {
        cut = new ClassUnderTest();
        cut.init(dc);
    }
    
    @Test
    public void testPing() {
        Mockito.when(dc.debug()).thenReturn(Boolean.TRUE);
        
        String expResult = "pong";
        String result = cut.ping();
        assertEquals(expResult, result);
    }
    
}
