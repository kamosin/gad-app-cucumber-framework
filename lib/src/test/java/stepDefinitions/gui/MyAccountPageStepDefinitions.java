package stepDefinitions.gui;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.MyAccountPage;
import testutils.contexts.GuiTestContext;
import testutils.contexts.UserContext;

public class MyAccountPageStepDefinitions {

    GuiTestContext guiTestContext;
    UserContext userContext;
    MyAccountPage myAccountPage;

    public MyAccountPageStepDefinitions(GuiTestContext guiTestContext, UserContext userContext) {
        this.guiTestContext = guiTestContext;
        this.userContext = userContext;
        this.myAccountPage = guiTestContext.pageObjectManager.getMyAccountPage();
    }

    @Then("User is redirected to account page")
    public void user_is_redirected_to_account_page() {
        Assert.assertEquals(myAccountPage.getWelcomeText(), "Hi " + userContext.getUser().email() + "!");
    }
}
