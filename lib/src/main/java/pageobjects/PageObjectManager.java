package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage getLandingPage(){
        return new LandingPage(driver);
    }

    public RegistrationPage getRegistrationPage(){
        return new RegistrationPage(driver);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public MyAccountPage getMyAccountPage(){
        return new MyAccountPage(driver);
    }
}
