package appTest.Base;
import appTest.uitily.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static appTest.uitily.DriverManager.logger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class HooksHandler extends BaseTest {
    private static ExtentReports  extentReports;
private ExtentTest test;
  /*  @Before(order = 0) // Ensure this runs before other @Before methods
    public void setupExtentReport() throws IOException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("mobileExtentReports.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        sparkReporter.config().setDocumentTitle(" Ecommerce  regression Report");
        sparkReporter.config().setReportName("regression package ");
         sparkReporter = new ExtentSparkReporter("extentReports.html");
       // sparkReporter.loadConfig(new File("path/to/extent-config.xml"));

    }*/



    @Before(order = 1)
    public void setup() throws MalformedURLException {
        driver = DriverManager.getDriver();
        if (driver == null) {
            logger.error("Failed to initialize the Appium driver.");
            throw new RuntimeException("Driver did not initialize properly.");
        }
        logger.info("Appium driver initialized successfully.");
        System.out.println("Setup completed successfully.");
    }
    @After
    public void tearDown(Scenario scenario) throws IOException {
        if(scenario.isFailed())
        {
            scenario.attach(getByteScreenshot(), "image/png", scenario.getName());
        }
        DriverManager.closeDriver();

    }
    public String takeScreenshot(AppiumDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(srcFile, destination);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to capture screenshot: " + e.getMessage();
        }
    }
    public byte[] getByteScreenshot() throws IOException
    {
        File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(src);
        return fileContent;
    }
}

