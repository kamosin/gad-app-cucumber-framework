package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cucumber/features",
        glue= {"stepDefinitions" },
        monochrome = true,
        tags = "@E2E",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGE2ETestsRunner extends AbstractTestNGCucumberTests {

}
