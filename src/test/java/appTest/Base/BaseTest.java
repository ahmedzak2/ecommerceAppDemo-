package appTest.Base;

import appTest.pages.Basepage;
import appTest.pages.Product;
import appTest.uitily.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AppiumDriver driver;
    private AppiumDriverLocalService service;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        // Start Appium server
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
        service.start();
        ConfigReader config = new ConfigReader();
        String system = config.getProperty("sofwareSystem");
// Use url in your Selenium test
        if (system.equals("android")) {

            // Configure driver options
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("sdk_gphone64_x86_64");
            options.setPlatformName("Android");
            options.setPlatformVersion("14");
            options.setAutomationName("UiAutomator2");  // Updated from 'Appium' to 'UiAutomator2'
            options.setApp("D:\\TESTING\\appium\\AppiumFrameworkDesign\\mobileAppFormZero\\src\\test\\java\\AppPacakage\\Android-MyDemoAppRN.1.3.0.build-244.apk");  // Make sure this is the correct path to your APK

            // Initialize driver
            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            Thread.sleep(10000);
            Basepage basepage = new Basepage(driver);

        }
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        // Stop Appium server
        if (service != null) {
            service.stop();
        }
    }
}
