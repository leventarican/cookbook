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
    private final static int[] ACTUAL_1 = {3, 4, 6};
    private final static int[] ACTUAL_2 = {1, 10, 7};
    private final static int[] ACTUAL_3 = {1, 219, 999};
    private final static int[] ACTUAL_4 = {39, 1, 7, 11, 16, 24, 25, 26};
    private final static int[] ACTUAL_5 = {155, 399};
    private final static String[] EXPECTED_1 = {"III", "IV", "VI"};
    private final static String[] EXPECTED_2 = {"I", "X", "VII"};
    private final static String[] EXPECTED_3 = {"I", "CCXIX", "CMXCIX"};
    private final static String[] EXPECTED_4 = {"XXXIX", "I", "VII", "XI", "XVI", "XXIV", "XXV", "XXVI"};
    private final static String[] EXPECTED_5 = {"CLV", "CCCXCIX"};

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

    // public void test1()
    // {
    //     String[] romanNumerals = App.toRomanNumerals(ACTUAL_1);
    //     for (int i = 0; i < ACTUAL_1.length; i++) {
    //         assertEquals(EXPECTED_1[i], romanNumerals[i]);
    //     }
    // }

    // public void test2()
    // {
    //     String[] romanNumerals = App.toRomanNumerals(ACTUAL_2);
    //     for (int i = 0; i < ACTUAL_2.length; i++) {
    //         assertEquals(EXPECTED_2[i], romanNumerals[i]);
    //     }
    // }

    // public void test3()
    // {
    //     String[] romanNumerals = App.toRomanNumerals(ACTUAL_3);
    //     for (int i = 0; i < ACTUAL_3.length; i++) {
    //         assertEquals(EXPECTED_3[i], romanNumerals[i]);
    //     }
    // }

    public void testa()
    {
        String[] romanNumerals = App.run(ACTUAL_5);
        for (int i = 0; i < ACTUAL_5.length; i++) {
            assertEquals(EXPECTED_5[i], romanNumerals[i]);
        }
    }
}
