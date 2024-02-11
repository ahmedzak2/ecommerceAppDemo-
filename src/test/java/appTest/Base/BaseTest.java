// BaseTest.java
package appTest.Base;
import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import io.appium.java_client.AppiumDriver;

import static appTest.uitily.DriverManager.logger;

public class BaseTest {
    public AppiumDriver driver;
    public Basepage basePage;
    protected Home homePage;
    public Product productPage;

    public void test() {
        if (driver == null) {
            logger.error("Driver did not initialize properly.");
            throw new RuntimeException("Driver did not initialize properly.");
        }
        logger.info("Driver is initialized.");
    }

}
