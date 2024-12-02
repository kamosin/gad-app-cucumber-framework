package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/cucumber/features",
        glue= {"stepDefinitions" },
        monochrome = true,
        tags = "@API",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class TestNGApiTestsRunner extends AbstractTestNGCucumberTests {


}
