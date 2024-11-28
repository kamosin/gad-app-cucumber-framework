package stepDefinitions.api;

import api.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.contexts.TestsContext;

public class UserSteps {

    TestsContext testsContext;
    Response userResponse;
    UserService userService;

    public UserSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.userService = new UserService(testsContext.getRequestManager());
    }

    @When("the user {string} registers using API")
    public void the_user_registers_using_api(String name) {
        userResponse = userService.createUser(testsContext.getUsers().get(name));
    }

    @Then("API response should be successful with status code {int}")
    public void api_response_should_be_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(userResponse.statusCode(), statusCode);
    }
}
