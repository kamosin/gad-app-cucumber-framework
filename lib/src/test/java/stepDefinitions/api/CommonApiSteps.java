package stepDefinitions.api;

import api.models.UserRequest;
import io.cucumber.java.en.Given;
import testutils.TestDataGenerator;
import testutils.contexts.UserContext;

public class CommonApiSteps {

    UserContext userContext;

    public CommonApiSteps(UserContext userContext) {
        this.userContext = userContext;
    }

    @Given("a new user is generated")
    public void a_new_user_is_generated() {
        userContext.setUser(TestDataGenerator.generateUser());
    }
}
