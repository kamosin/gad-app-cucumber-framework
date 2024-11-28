package stepDefinitions.gui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginPage;
import testutils.contexts.TestsContext;

public class LoginPageStepDefinitions {

    TestsContext testsContext;
    LoginPage loginPage;


    public LoginPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.loginPage = testsContext.getPageObjectManager().getLoginPage();
    }

    @Then("The user is redirected to the login page")
    public void the_user_is_redirected_to_the_login_page() {
        Assert.assertTrue(loginPage.checkIfOnLoginUrl());
    }

    @When("Registered user {string} logs in")
    public void registered_user_logs_in(String name) {
        var user = testsContext.getUsers().get(name);
        loginPage.login(user.email(), user.password());
    }
}
