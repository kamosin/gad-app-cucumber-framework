package stepDefinitions.gui;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import testutils.contexts.TestsContext;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestsContext testsContext;

    public Hooks(TestsContext testsContext) {
        this.testsContext = testsContext;
    }

    @Before("@GUI")
    public void guiSetup(){
        this.testsContext.setupBaseTest();
        this.testsContext.setupPageObjectManager();
        this.testsContext.setupCommonComponent();
    }

    @Before("@RequestManager")
    public void apiSetup(){
        this.testsContext.setupRequestManager();
    }

    @After("@GUI")
    public void tearDown(){
        if(testsContext.getBaseTest().driver!=null){
            testsContext.getBaseTest().driver.quit();
        }
    }

    @AfterStep("@GUI")
    public  void addScreenshot(Scenario scenario) throws IOException {
        var driver = testsContext.getBaseTest().getDriver();
        if(scenario.isFailed()){
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            var fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent, "image/png", "image");
        }
    }
}
