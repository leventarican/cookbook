package dojo.kata;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    private final static String ACTUAL_1 = "this is";
    private final static String ACTUAL_2 = "this is another test";
    // private final static String EXPECTED_1 = "t:1, h:1, i:2, s:2, _:1";
    private final static String EXPECTED_1 = "t:1, h:1, i:2, s:2,  :1";
    private final static String EXPECTED_2 = "t:4, h:2, i:2, s:3,  :3, a:1, n:1, o:1, e:2, r:1";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertEquals(EXPECTED_1, App.count(ACTUAL_1));
    }

    public void test2()
    {
        assertEquals(EXPECTED_2, App.count(ACTUAL_2));
    }
}
