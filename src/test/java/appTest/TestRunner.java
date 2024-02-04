package appTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/appTest/product/buyProduct", // path to your feature files
        glue = "appTest.product.buyProduct", // the package containing your step definitions
        plugin = {"pretty", "html:target/cucumber-reports"},
        monochrome = true
)

public class TestRunner {
    // No additional code needed here
}

