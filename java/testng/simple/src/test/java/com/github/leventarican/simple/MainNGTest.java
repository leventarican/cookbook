package com.github.leventarican.simple;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Create/Update Test in NetBeans with: Main.java > Tools > Create/Update Tests
 *
 * @author Levent
 */
public class MainNGTest {
    
    public MainNGTest() {
    }

    /**
     * Test of main method, of class Main.
     */
    @Test(enabled = false)
    public void testMain() {
        System.out.println("main");
        String[] args = {
            "Junit", "TestNG"
        };
        Main.main(args);
    }
    
    @Test(groups = "regression")
    public void regressionTest0() {
        assertEquals(0, 0);
    }
    
    @Test(groups = "regression")
    public void regressionTest1() {
        assertEquals(1, 2);
    }
    
    /**
     * depends on groups regression:
     * if regression test all successful then this will be executed.
     */
    @Test(dependsOnGroups = "regression")
    public void approvalTest() {
        System.out.println("this test case will never executed until groups regression is successful.");
        assertEquals(1, 1);
    }
    
    @DataProvider(name = "data-provider")
    public Object[][] data() {
        return new Object[][] {
            {"JUnit"},
            {"TestNG"}
        };
    }
    
    @Test(dataProvider = "data-provider")
    public void dataTest(String testFramework) {
        System.out.println("test framework: " + testFramework);
    }
    
    @Test(invocationCount = 3)
    public void bunch() {
        System.out.println("###");
    }

    /**
     * Test of binarySearch method, of class Main.
     */
    @Test
    public void testBinarySearch() {
        System.out.println("binarySearch");
        int[] numbers = {5, 3, 8};
        int number = 3;
        int expResult = 1;
        int result = Main.binarySearch(numbers, number);
        assertEquals(result, expResult);
    }
    
}
