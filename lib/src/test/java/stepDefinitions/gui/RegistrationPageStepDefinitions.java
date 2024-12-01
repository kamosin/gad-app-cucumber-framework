package stepDefinitions.gui;

import api.models.UserRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.NavigationBar;
import pageobjects.RegistrationPage;
import testutils.ReusableData;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

import java.util.List;

public class RegistrationPageStepDefinitions {

    TestsContext testsContext;
    RegistrationPage registrationPage;
    NavigationBar navigationBar;
    String registrationInfo;

    public RegistrationPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.registrationPage = testsContext.getPageObjectManager().getRegistrationPage();
        this.navigationBar = testsContext.getPageObjectManager().getNavigationBar();
    }

    @When("User {string} is registered with valid data on registration page")
    public void user_registers_with_valid_data_on_registration_page(String name) {
        var user = TestDataGenerator.generateUser(name);
        testsContext.getUsers().put(name, user);
        registrationInfo = registrationPage.registerWithAllFields(user);
    }

    @Then("A {string} popup should appear")
    public void a_popup_should_appear(String userMessage) {
        Assert.assertEquals(registrationInfo, userMessage);
    }

    @When("User {string} is registered using existing email")
    public void userRegistersUsingExistingEmail(String name) {
        var user = new UserRequest(name, TestDataGenerator.generateLastName(), testsContext.getUsers().get("John").email(),
                TestDataGenerator.generateBirthdate(), TestDataGenerator.generatePassword(), ReusableData.userAvatar);
        testsContext.getUsers().put(name, user);
        registrationInfo = registrationPage.registerWithAllFields(user);
    }

    @When("User tries to register only with email address")
    public void userTriesToRegisterOnlyWithEmailAddress() {
        navigationBar.clickRegisterButton();
        registrationPage.enterEmail(TestDataGenerator.generateEmail());
        registrationPage.clickRegisterButton();
    }

    @Then("{string} information is displayed below first name, last name, and password fields")
    public void informationIsDisplayedBelowFirstNameLastNameAndPasswordFields(String requiredFieldInfo) {
        Assert.assertTrue(registrationPage.isPasswordValidationTextVisible(requiredFieldInfo) &&
                registrationPage.isLastNameValidationTextVisible(requiredFieldInfo) &&
                registrationPage.isFirstNameValidationTextVisible(requiredFieldInfo));
    }

    @When("user tries to register with data")
    public void userTriesToRegisterWithData(List<String> data) {
        navigationBar.clickRegisterButton();
        registrationPage.enterAllData(data.getFirst(), data.get(1), data.get(2), data.get(3),
                TestDataGenerator.generatePassword(), ReusableData.userAvatar);
        registrationPage.clickRegisterButton();
    }

    @Then("Following messages are displayed")
    public void followingMessagesAreDisplayed(List<String> data) {
        Assert.assertTrue(registrationPage.isFirstNameValidationTextVisible(data.getFirst()) &&
                registrationPage.isLastNameValidationTextVisible(data.get(1)) &&
                registrationPage.isEmailValidationTextVisible(data.get(2)) &&
                registrationPage.isDateValidationTextVisible(data.get(3)));
    }
}
