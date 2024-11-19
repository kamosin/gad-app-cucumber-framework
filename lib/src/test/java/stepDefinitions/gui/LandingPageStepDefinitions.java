package stepDefinitions.gui;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageobjects.LandingPage;
import testutils.contexts.GuiTestContext;

public class LandingPageStepDefinitions {

    GuiTestContext guiTestContext;
    LandingPage landingPage;

    public LandingPageStepDefinitions(GuiTestContext guiTestContext) {
        this.guiTestContext = guiTestContext;
        this.landingPage = guiTestContext.pageObjectManager.getLandingPage();
    }

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        Assert.assertTrue(landingPage.checkIfStartButtonIsVisible());
    }


}
