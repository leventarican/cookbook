package com.github.leventarican.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Levent
 */
public class ClassUnderTestTest {
    
    @Mock
    DependenyClass dc;
    
    @Spy
    SpyClass sc;
    
    @InjectMocks
    ClassUnderTest cut;
    
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testMock() {
        Mockito.when(dc.debug()).thenReturn(Boolean.TRUE);
        String result = cut.ping();
        assertEquals(result, "pong");
    }
    
    @Test
    public void testSpy() {
        String result = sc.password();
        assertEquals(result, "code");
    }
}
