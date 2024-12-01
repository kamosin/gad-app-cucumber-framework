package stepDefinitions.api;

import api.LoginService;
import api.models.LoginRequest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.contexts.TestsContext;

public class LoginSteps {

    TestsContext testsContext;
    Response requestResponse;
    LoginService loginService;

    public LoginSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.loginService = new LoginService(testsContext.getRequestManager());
        this.requestResponse = testsContext.getRequestResponse();
    }

    @When("the user {string} attempts to log in")
    public void the_user_attempts_to_log_in(String name) {
        var user = testsContext.getUsers().get(name);
        testsContext.getRequestManager().setToken(new LoginRequest(user.email(), user.password()));
    }

    @When("User logs out using API")
    public void userLogsOutUsingAPI() {
        loginService.logout();
    }

    @Then("the login should be successful with status code {int}")
    public void the_login_should_be_successful_with_status_code(Integer statusCode) {
        Assert.assertEquals(testsContext.getRequestResponse().getStatusCode(), statusCode);
    }
}
