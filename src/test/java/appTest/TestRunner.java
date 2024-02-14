package appTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.util.AbstractSet;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/appTest/product", // path to your feature files
        glue = "appTest", // the package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

public class TestRunner {
    // No additional code needed here
}

