package stepDefinitions.gui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.LoginPage;
import pageobjects.NavigationBar;
import pageobjects.RegistrationPage;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

public class CommonGuiSteps {

    TestsContext testsContext;
    RegistrationPage registrationPage;
    NavigationBar navigationBar;
    LoginPage loginPage;

    public CommonGuiSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.registrationPage = testsContext.getPageObjectManager().getRegistrationPage();
        this.loginPage = testsContext.getPageObjectManager().getLoginPage();
        this.navigationBar = testsContext.getPageObjectManager().getNavigationBar();
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

    @When("User is logged out")
    public void userIsLoggedOut() {
        navigationBar.clickLogoutButton();
    }

    @And("User opens flashposts Page")
    public void userOpensFlashpostsPage() {
        navigationBar.clickFlashpostsPageButton();
    }
}
