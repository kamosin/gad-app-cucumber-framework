package testutils;

import api.testutils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageobjects.CommonComponent;
import pageobjects.LandingPage;
import pageobjects.NavigationBar;

import java.util.Objects;

public class GuiBaseTest {

    public WebDriver driver;
    protected NavigationBar navigationBar;
    protected CommonComponent commonComponent;
    protected String appUrl = TestUtils.getGlobalValue("baseUrl");

    public WebDriver getDriver(){
        if(driver == null){
            driver = new ChromeDriver(new ChromeOptions());
            driver.manage().window().maximize();
            driver.get(appUrl);
            return driver;
        }
        return driver;
    }




}
