package stepDefinitions.gui;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.MyAccountPage;
import testutils.contexts.TestsContext;

public class MyAccountPageStepDefinitions {

    MyAccountPage myAccountPage;
    TestsContext testsContext;

    public MyAccountPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.myAccountPage = testsContext.getPageObjectManager().getMyAccountPage();
    }

    @Then("User {string} is redirected to account page")
    public void user_is_redirected_to_account_page(String name) {
        Assert.assertEquals(myAccountPage.getWelcomeText(), "Hi " + testsContext.getUsers().get(name).email() + "!");
    }
}
