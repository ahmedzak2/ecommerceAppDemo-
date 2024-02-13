package appTest.uitily;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.MalformedURLException;
import java.time.Duration;

public class DriverManager {
    private static AppiumDriver driver = null;
    private static AppiumDriverLocalService service;
    public static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

    private DriverManager() { }

    public static synchronized AppiumDriver getDriver()  {
        if (driver == null) {
            try {
                // Specify the log file for Appium server logs
                File logFile = new File("appium.log");
                AppiumServiceBuilder builder = new AppiumServiceBuilder()
                        .withLogFile(logFile); // Direct server logs to the specified file

                service = AppiumDriverLocalService.buildService(builder);
                service.start();

                UiAutomator2Options options = new UiAutomator2Options();
                options.setDeviceName("sdk_gphone64_x86_64");
                options.setPlatformName("Android");
                options.setPlatformVersion("14");
                options.setAutomationName("UiAutomator2");
                options.setApp("D:\\TESTING\\appium\\AppiumFrameworkDesign\\mobileAppFormZero\\src\\test\\java\\AppPacakage\\Android-MyDemoAppRN.1.3.0.build-244.apk");

                driver = new AndroidDriver(service.getUrl(), options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                logger.info("Appium driver initialized successfully");
            } catch (Exception e) {
                logger.error("Error initializing Appium driver: ", e);
                // It's important to log or handle the exception here to understand what went wrong.
                throw e; // Rethrow the exception to signal failure in driver initialization
            }
        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            logger.info("Closing Appium driver");
            driver.quit();
            driver = null;
        }
        if (service != null) {
            logger.info("Stopping Appium service");
            service.stop();
        }
    }
}
