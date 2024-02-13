package appTest.Base;
import appTest.Base.BaseTest;
import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

import static appTest.uitily.DriverManager.logger;

public class HooksHandler extends BaseTest {

    @Before(order = 1)
    public void setup() throws MalformedURLException {
        driver = DriverManager.getDriver();
        if (driver == null) {
            logger.error("Failed to initialize the Appium driver.");
            throw new RuntimeException("Driver did not initialize properly.");
        }
        logger.info("Appium driver initialized successfully.");

        // Initialize page objects here
        /*basePage = new Basepage(driver);
        productPage = new Product(driver);
        homePage = new Home(driver);*/
        logger.info("Page objects initialized successfully.");
        // Assuming productPage.print() is a method for debugging or logging
        //productPage.print();

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

