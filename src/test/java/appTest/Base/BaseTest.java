package appTest.Base;
import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.Before;

import static appTest.uitily.DriverManager.getDriver;
import static appTest.uitily.DriverManager.logger;
public class BaseTest  {
    public AppiumDriver driver  ;
    public  Basepage basePage = new Basepage(); ;
    public  Home homePage = new Home() ;
    public  Product productPage = new Product() ;

    public void test() {
        if (getDriver() == null) {
            logger.error("Driver did not initialize properly.");
            throw new RuntimeException("Driver did not initialize properly.");
        }
        logger.info("Driver is initialized.+ziko");
    }
}
