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
        this.userResponse = testsContext.getUserResponse();
    }

    @When("the user {string} registers using API")
    public void the_user_registers_using_api(String name) {
        var response = userService.createUser(testsContext.getUsers().get(name));
        testsContext.setUserResponse(response);
    }



}
