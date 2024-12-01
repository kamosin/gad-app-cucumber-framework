package stepDefinitions.api;

import api.models.UserRequest;
import api.testutils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.ReusableData;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

public class CommonApiSteps {

    TestsContext testsContext;
    Response userResponse;

    public CommonApiSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.userResponse = testsContext.getUserResponse();
    }

    @Given("A new user {string} is generated")
    public void a_new_user_is_generated(String name) {
        var user = TestDataGenerator.generateUser(name);
        testsContext.getUsers().put(user.firstname(), user);
    }

    @When("A new user {string} is generated with existing email")
    public void aNewUserIsGeneratedWithExistingEmail(String name) {
        var user = new UserRequest(name, TestDataGenerator.generateLastName(), testsContext.getUsers().get("Gary").email(),
                TestDataGenerator.generateBirthdate(), TestDataGenerator.generatePassword(), ReusableData.userAvatar);
        testsContext.getUsers().put(name, user);
    }

    @Given("A new user {string} only with email is generated")
    public void aNewUserOnlyWithEmailIsGenerated(String name) {
        var user = new UserRequest(name, null, TestDataGenerator.generateEmail(), null, null, null);
        testsContext.getUsers().put(name, user);
    }

    @Given("A new user {string} with wrong birth date format is generated")
    public void aNewUserWithWrongBirthDateFormatIsGenerated(String name) {
        var user = new UserRequest(TestDataGenerator.generateFirstName(), TestDataGenerator.generateLastName(),
                "12-12-1996", TestDataGenerator.generateBirthdate(), TestDataGenerator.generatePassword(), ReusableData.userAvatar);
        testsContext.getUsers().put(name, user);
    }


    @Then("API response should end with status code {int}")
    public void api_response_should_be_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(testsContext.getUserResponse().statusCode(), statusCode);
    }

    @And("API response should contain {string} message")
    public void apiResponseShouldContainMessage(String message) {
        Assert.assertEquals(TestUtils.getJsonPath(testsContext.getUserResponse(), "error.message"), message);
    }

}
