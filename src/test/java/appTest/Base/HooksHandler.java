package appTest.Base;
import appTest.Base.BaseTest;
import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class HooksHandler extends BaseTest {
    @Before
    public void setup() throws MalformedURLException, MalformedURLException {
        driver = DriverManager.getDriver();
        if (driver == null) {
            throw new RuntimeException("Driver did not initialize properly.");
        }

        // Initialize your pages with the driver
        try {
            basePage = new Basepage(driver);
            productPage = new Product(driver);
            homePage = new Home(driver); // Assuming Home constructor follows the same pattern
        } catch (Exception e) {
            // Catch any exceptions during page initialization and throw a runtime exception
            throw new RuntimeException("Page initialization failed: " + e.getMessage());
        }

        // Optional: Add a simple assertion or a log statement to confirm setup completion
        System.out.println("Setup completed successfully.");
    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();

    }
}

