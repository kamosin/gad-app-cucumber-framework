package stepDefinitions.gui;

import api.models.UserRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.RegistrationPage;
import testutils.contexts.GuiTestContext;
import testutils.TestDataGenerator;
import testutils.contexts.UserContext;

public class RegistrationPageStepDefinitions {

    GuiTestContext guiTestContext;
    RegistrationPage registrationPage;
    UserContext userContext;
    String registrationInfo;

    public RegistrationPageStepDefinitions(GuiTestContext guiTestContext, UserContext userContext) {
        this.guiTestContext = guiTestContext;
        this.userContext = userContext;
        this.registrationPage = guiTestContext.pageObjectManager.getRegistrationPage();
    }

    @When("User registers with valid data on registration page")
    public void user_registers_with_valid_data_on_registration_page() {
        userContext.setUser(TestDataGenerator.generateUser());
        registrationInfo = registrationPage.registerWithAllFields(userContext.getUser().firstname(),
                userContext.getUser().lastname(), userContext.getUser().email(),
                userContext.getUser().birthDate(), userContext.getUser().password(), userContext.getUser().avatar());
    }

    @Then("A {string} popup should appear")
    public void a_popup_should_appear(String userCreatedMessage) {
        Assert.assertEquals(registrationInfo, userCreatedMessage);
    }

    @When("User registers using existing email")
    public void userRegistersUsingExistingEmail() {
        registrationInfo = registrationPage.registerWithAllFields(userContext.getUser().firstname(),
                userContext.getUser().lastname(), userContext.getUser().email(),
                userContext.getUser().birthDate(), userContext.getUser().password(), userContext.getUser().avatar());
    }

    @Then("{string} popup should be displayed")
    public void popupShouldBeDisplayed(String emailNotUniqueExpectedMessage) {
        Assert.assertEquals(registrationInfo, emailNotUniqueExpectedMessage);
    }
}
