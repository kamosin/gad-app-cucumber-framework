package stepDefinitions.gui;

import api.models.UserRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import testutils.GuiBaseTest;
import testutils.TestDataGenerator;

public class RegistrationTestsStepsGui extends GuiBaseTest {

    RegistrationPage registrationPage;
    LoginPage loginPage;
    UserRequest user;
    String registrationInfo;

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        launchApplication();
    }
    @When("User clicks the Register button on navigation bar")
    public void user_clicks_the_register_button_on_navigation_bar() {
        registrationPage = navigationBar.clickRegisterButton();
    }
    @Then("The Registration page should be displayed")
    public void the_registration_page_should_be_displayed() {
        Assert.assertEquals(driver.getCurrentUrl(), appUrl+"/register.html");
    }
    @When("User enters all required registration data")
    public void user_enters_all_required_registration_data() {
        user = TestDataGenerator.generateUser();
        registrationPage.enterAllData(user.firstname(), user.lastname(), user.email(), user.birthDate(),
                user.password(), user.avatar());
    }
    @When("Clicks the Register button")
    public void clicks_the_register_button() {
         registrationInfo = registrationPage.clickRegisterButton();
    }

    @Then("A {string} popup should appear")
    public void a_popup_should_appear(String userCreatedMessage) {
        Assert.assertEquals(registrationInfo, userCreatedMessage);
    }
    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {
        var loginUrl = appUrl + "/login/";
        commonComponent.waitForUrlToBeLoaded(loginUrl);
        loginPage = new LoginPage(driver);
        Assert.assertEquals(driver.getCurrentUrl(), appUrl+"/login/");
    }
    @When("User enters email and password on the login page")
    public void user_enters_email_and_password_on_the_login_page() {
        loginPage.enterAllLoginData(user.email(), user.password());
    }
    @When("Clicks the Login button")
    public void clicks_the_Login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User should be redirected to the account page")
    public void user_should_be_redirected_to_the_account_page() {
        Assert.assertEquals(driver.getCurrentUrl(), appUrl + "/welcome");
        driver.close();
    }
}
