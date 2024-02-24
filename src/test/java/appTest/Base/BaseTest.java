package appTest.Base;
import appTest.pages.*;
import appTest.uitily.ConfigReader;
import io.appium.java_client.AppiumDriver;

import static appTest.uitily.DriverManager.getDriver;
import static appTest.uitily.DriverManager.logger;
public class BaseTest  {
    public AppiumDriver driver  ;
    public  Basepage basePage = new Basepage(); ;
    public Cart homePage = new Cart() ;
    public  Product productPage = new Product() ;
    public Cart cartPage =new Cart();
    public ConfigReader configReader = new ConfigReader("src/test/resources/userInfoData.properties");
  public Login login = new Login();
  public CheckOutPage checkOutPage =new CheckOutPage();
    public void test() {
        if (getDriver() == null) {
            logger.error("Driver did not initialize properly.");
            throw new RuntimeException("Driver did not initialize properly.");
        }
        logger.info("Driver is initialized.+ziko");
    }
}
