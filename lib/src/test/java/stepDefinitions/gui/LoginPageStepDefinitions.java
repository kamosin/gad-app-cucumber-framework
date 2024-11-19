package stepDefinitions.gui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginPage;
import testutils.contexts.GuiTestContext;
import testutils.contexts.UserContext;

public class LoginPageStepDefinitions {

    GuiTestContext guiTestContext;
    UserContext userContext;
    LoginPage loginPage;

    public LoginPageStepDefinitions(GuiTestContext guiTestContext, UserContext userContext) {
        this.guiTestContext = guiTestContext;
        this.userContext = userContext;
        this.loginPage = guiTestContext.pageObjectManager.getLoginPage();
    }

    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {
        Assert.assertTrue(loginPage.checkIfOnLoginUrl());
    }

    @When("Registered user logs in")
    public void registered_user_logs_in() {
        loginPage.login(userContext.getUser().email(), userContext.getUser().password());
    }
}
