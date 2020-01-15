/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.nio.file.Path;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * NetBeans example:
 * Project > Run Selenium Test
 * Test Packages > New File > Selenium Test Case
 *
 * @author Levent
 */
public class Basic {
    
    // your path to geckodriver: https://github.com/mozilla/geckodriver/releases
    File geckodriver = new File(Path.of(System.getProperty("user.dir")).getParent().toAbsolutePath().toString(), "geckodriver");
    
    @Before
    public void testExecutionPath() {
        System.setProperty("webdriver.gecko.driver", geckodriver.toString());
        System.out.println("geckdriver path: " + geckodriver.toString());
    }
    
    @Test
    public void testSimple() throws Exception {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit NetBeans
        driver.get("http://www.netbeans.org");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.netbeans.org");

        // Check the title of the page
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getTitle().contains("NetBeans");
            }
        });

        //Close the browser
        driver.quit();
    }
    
}
