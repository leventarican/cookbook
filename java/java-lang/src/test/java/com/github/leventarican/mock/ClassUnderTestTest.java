package com.github.leventarican.mock;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 * @author Levent
 */
public class ClassUnderTestTest {
    
    @Mock
    DependenyClass dc;
    
    @InjectMocks
    ClassUnderTest cut;
    
//    @Before
//    public void init() {
//        cut = new ClassUnderTest();
//        cut.init(dc);
//    }
    
//    @Test
    public void testPing() {
        Mockito.when(dc.debug()).thenReturn(Boolean.TRUE);
        
        String expResult = "pong";
        String result = cut.ping();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testConstructor() {
        System.out.println("testConsructor");
        
        Mockito.when(dc.debug()).thenReturn(Boolean.TRUE);
        
        String result = cut.ping();
        System.out.println(result);
    }
}
