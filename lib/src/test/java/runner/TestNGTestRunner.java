package runner;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//
//@RunWith(Cucumber.class)
//@CucumberOptions(
//        features = "src/test/resources/cucumber/features",
//        glue = {"stepDefinitions", "testutils"}
//)
//public class RunCucumberTest{
//}

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = "src/test/resources/cucumber/features",
        glue= {"stepDefinitions" }
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}