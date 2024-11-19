package stepDefinitions.api;

import api.UserService;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.contexts.ApiTestContext;
import testutils.contexts.UserContext;

public class UserSteps {

    ApiTestContext apiTestContext;
    UserContext userContext;
    Response userResponse;
    UserService userService;

    public UserSteps(ApiTestContext apiTestContext, UserContext userContext) {
        this.apiTestContext = apiTestContext;
        this.userContext = userContext;
        this.userService = new UserService(apiTestContext.requestManager);
    }

    @When("the user registers using API")
    public void the_user_registers_using_api() {
        userResponse = userService.createUser(userContext.getUser());
    }

    @Then("API response should be successful with status code {int}")
    public void api_response_should_be_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(userResponse.statusCode(), statusCode);
    }
}
