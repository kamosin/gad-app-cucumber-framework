package testutils;

import api.testutils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.CommonComponent;
import pageobjects.LandingPage;
import pageobjects.NavigationBar;

public class GuiBaseTest {

    public WebDriver driver;
    protected NavigationBar navigationBar;
    protected CommonComponent commonComponent;
    protected String appUrl = TestUtils.getGlobalValue("baseUrl");

    public void launchApplication(){
        initializeDriver();
        var landingPage = new LandingPage(driver);
        landingPage.goToLandingPage(appUrl);
    }

    private void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        commonComponent = new CommonComponent(driver);
        navigationBar = new NavigationBar(driver);
        driver.manage().window().maximize();

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }

}
