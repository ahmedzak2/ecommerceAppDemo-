package appTest.Base;
import appTest.Base.BaseTest;
import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

import static appTest.uitily.DriverManager.logger;

public class HooksHandler extends BaseTest {
    @Before
    public void setup() throws MalformedURLException {
        driver = DriverManager.getDriver();
        if (driver == null) {
            logger.error("Driver did not initialize properly.");
            throw new RuntimeException("Driver did not initialize properly.");
        } else {
            logger.info("Appium driver initialized successfully.");
        }
             // Initialize your pages with the driver
        basePage = new Basepage(driver);
        productPage = new Product(driver);
        homePage = new Home(driver);

        // Assuming productPage.print() is a method for debugging or logging
        productPage.print();

        // Assuming driver.getStatus() is valid and intended for debugging or logging
        // Note: getStatus() is not a standard Appium method. Make sure this is implemented correctly.
        System.out.println(driver.getStatus() + " Hazem");

        // Optional: Add a simple assertion or a log statement to confirm setup completion
        System.out.println("Setup completed successfully.");
    }
    @After
    public void tearDown() {
        DriverManager.closeDriver();

    }
}

