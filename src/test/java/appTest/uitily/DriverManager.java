package appTest.uitily;

// DriverManager.java
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static AppiumDriver driver = null;
    private static AppiumDriverLocalService service;

    private DriverManager() { }

    public static synchronized AppiumDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder());
            service.start();

            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName("sdk_gphone64_x86_64");
            options.setPlatformName("Android");
            options.setPlatformVersion("14");
            options.setAutomationName("UiAutomator2");
            options.setApp("D:\\TESTING\\appium\\AppiumFrameworkDesign\\mobileAppFormZero\\src\\test\\java\\AppPacakage\\Android-MyDemoAppRN.1.3.0.build-244.apk");

            driver = new AndroidDriver(service.getUrl(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        if (service != null) {
            service.stop();
        }
    }
}
