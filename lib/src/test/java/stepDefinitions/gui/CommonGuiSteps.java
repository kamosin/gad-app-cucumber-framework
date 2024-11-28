package stepDefinitions.gui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

public class CommonGuiSteps {

    TestsContext testsContext;
    RegistrationPage registrationPage;
    LoginPage loginPage;

    public CommonGuiSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.registrationPage = testsContext.getPageObjectManager().getRegistrationPage();
        this.loginPage = testsContext.getPageObjectManager().getLoginPage();
    }

    @Given("New user {string} is registered and logged in")
    public void newUserIsRegisteredAndLoggedIn(String name) {
        var user = TestDataGenerator.generateUser(name);
        registrationPage.registerWithAllFields(user);
        loginPage.login(user.email(), user.password());
        testsContext.getUsers().put(name, user);
    }

    @Then("A {string} popup is displayed")
    public void aPopupIsDisplayed(String popupData) {
        Assert.assertEquals(testsContext.getCommonComponent().getPopupText(), popupData);
    }

    @Then("A {string} simple alert text is displayed")
    public void aSimpleAlertTextIsDisplayed(String simpleAlertText) {
        Assert.assertTrue(testsContext.getCommonComponent().getSimpleAlertsText().contains(simpleAlertText));
    }
}
