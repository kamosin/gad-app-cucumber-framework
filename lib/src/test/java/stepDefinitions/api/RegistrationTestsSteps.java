package stepDefinitions.api;

import api.LoginService;
import api.RequestManager;
import api.UserService;
import api.models.LoginRequest;
import api.models.UserRequest;
import api.testutils.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.TestDataGenerator;

public class RegistrationTestsSteps {

//    RequestManager requestManager = new RequestManager();
//    UserService userService = new UserService(requestManager);
//    LoginService loginService = new LoginService(requestManager);
//    UserRequest user;
//    UserRequest anotherUser;
//    Response userResponse;
//    Response loginResponse;
//    @Given("a new user is generated")
//    public void a_new_user_is_generated() {
//        user = TestDataGenerator.generateUser();
//    }
//    @When("the user registers using API")
//    public void the_user_registers_using_api() {
//        userResponse = userService.createUser(user);
//    }
//    @Then("API response should be successful with status code {int}")
//    public void api_response_should_be_successful_with_status_code(Integer statusCode) {
//        Assert.assertEquals(userResponse.statusCode(), statusCode);
//    }
//    @When("the user attempts to log in")
//    public void the_user_attempts_to_log_in() {
//        loginResponse = loginService.login(new LoginRequest(user.email(), user.password()));
//    }
//    @Then("the login should be successful with status code {int}")
//    public void the_login_should_be_successful_with_status_code(Integer statusCode) {
//        Assert.assertEquals(loginResponse.getStatusCode(), statusCode);
//    }
//
//    @When("Another user is generated with the same email as the former user")
//    public void another_user_is_generated_with_the_same_email_as_the_former_user() {
//        anotherUser = new UserRequest(TestDataGenerator.generateFirstName(), TestDataGenerator.generateLastName(),
//                user.email(), TestDataGenerator.generateBirthdate(), TestDataGenerator.generatePassword(), "0797eae7-5f95-4985-8ac8-10c58e17c769.jpg");
//    }
//    @When("Another user tries to register")
//    public void another_user_tries_to_register() {
//        userResponse = userService.createUser(anotherUser);
//    }
//    @Then("API response should not be successful with status code {int}")
//    public void api_response_should_not_be_successful_with_status_code(Integer statusCode) {
//        Assert.assertEquals(userResponse.getStatusCode(), statusCode);
//    }
//    @Then("Error message should be {string}")
//    public void error_message_should_be(String errorMessage) {
//        Assert.assertEquals(TestUtils.getJsonPath(userResponse, "error.message"), errorMessage);
//    }
}
