package stepDefinitions.api;

import api.UserService;
import api.models.LoginRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import testutils.contexts.TestsContext;

public class UserSteps {

    TestsContext testsContext;
    Response requestResponse;
    UserService userService;

    public UserSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.userService = new UserService(testsContext.getRequestManager());
        this.requestResponse = testsContext.getRequestResponse();
    }

    @When("the user {string} registers using API")
    public void the_user_registers_using_api(String name) {
        var response = userService.createUser(testsContext.getUsers().get(name));
        testsContext.setRequestResponse(response);
    }
}
