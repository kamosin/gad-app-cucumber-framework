package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

public class CommonApiSteps {

    TestsContext testsContext;

    public CommonApiSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
    }

    @Given("a new user {string} is generated")
    public void a_new_user_is_generated(String name) {
        var user = TestDataGenerator.generateUser(name);
        testsContext.getUsers().put(user.firstname(), user);
    }

}
