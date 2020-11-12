package com.github.leventarican.dojo;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Kata2Test {
    @Test
    public void shouldWorkForSomeExamples() throws Exception {
      assertEquals("negative numbers aren't square numbers", false, Kata2.isSquare(-1));
      assertEquals("0 is a square number (0 * 0)",    true,   Kata2.isSquare(0));
      assertEquals("3 isn't a square number", false,  Kata2.isSquare(3));
      assertEquals("4 is a square number (2 * 2)",    true,   Kata2.isSquare(4));
      assertEquals("25 is a square number (5 * 5)",   true,   Kata2.isSquare(25));
      assertEquals("26 isn't a square number",false,  Kata2.isSquare(26));
//      assertEquals("9841633: ",false,  Kata2.isSquare(9841633));
    }
}