// BaseTest.java
package appTest.Base;

import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;

public class BaseTest {
    protected AppiumDriver driver;
    protected Basepage basePage;
    protected Home homePage;
    protected Product productPage;

    @BeforeMethod
    public void setup() throws MalformedURLException, MalformedURLException {
        driver = DriverManager.getDriver();
     //   basePage = new Basepage(driver);
        productPage = new Product(driver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.closeDriver();
    }
}
