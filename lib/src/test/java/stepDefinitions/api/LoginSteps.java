package stepDefinitions.api;

import api.LoginService;
import api.models.LoginRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.contexts.ApiTestContext;
import testutils.contexts.UserContext;

public class LoginSteps {

    ApiTestContext apiTestContext;
    UserContext userContext;
    Response loginResponse;
    LoginService loginService;

    public LoginSteps(ApiTestContext apiTestContext, UserContext userContext) {
        this.apiTestContext = apiTestContext;
        this.userContext = userContext;
        this.loginService = new LoginService(apiTestContext.requestManager);
    }

    @When("the user attempts to log in")
    public void the_user_attempts_to_log_in() {
        loginResponse = loginService.login(new LoginRequest(userContext.getUser().email(), userContext.getUser().password()));
    }

    @Then("the login should be successful with status code {int}")
    public void the_login_should_be_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(loginResponse.getStatusCode(), statusCode);
    }
}
