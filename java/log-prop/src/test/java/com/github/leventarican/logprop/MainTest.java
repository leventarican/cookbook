package com.github.leventarican.logprop;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Levent
 */
public class MainTest {
    
    private final Logger logger = LoggerFactory.getLogger(Main.class);
    private Properties properties = new Properties();
    private Main cut;
    
    @Before
    public void init() {
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream("test.properties"));
            cut = new Main();
        } catch (IOException ex) {
            logger.error("init: ", ex);
        }
    }
    
    @Test
    public void test_case_0() {
        logger.info("test case 0");
        assertTrue(cut.ping().equals("pong"));
    }

    @Test
    public void test_case_1() {
        logger.info("test case 1");
        
        String expected = "0.0.1";
        String actual = (String) properties.get("version");
        
        logger.info("version: " + actual);
        
        assertTrue(expected.equals(actual));
    }
    
}
