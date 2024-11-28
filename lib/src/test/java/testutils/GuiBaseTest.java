package testutils;

import api.testutils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GuiBaseTest {

    public WebDriver driver;
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
