package com.github.leventarican;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

	@Test
	public void step0() {
		assertEquals("foobar", "foobar");
	}

	@Test
	public void step1() {
        App app = new App();
		assertEquals("<html><code>java with apache velocity</code></html>", app.velocity());
	}
}
