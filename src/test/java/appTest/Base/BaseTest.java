// BaseTest.java
package appTest.Base;

import appTest.pages.Basepage;
import appTest.pages.Home;
import appTest.pages.Product;
import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

public class BaseTest {
    protected AppiumDriver driver;
    protected Basepage basePage;
    protected Home homePage;
    public Product productPage;

    @Before
    public void setup() throws MalformedURLException, MalformedURLException {
        driver = DriverManager.getDriver();
     //   basePage = new Basepage(driver);
        productPage = new Product(driver);
        homePage = new Home(driver);  // Instantiate Home

    }

    @After
    public void tearDown() {
        DriverManager.closeDriver();

    }
}
