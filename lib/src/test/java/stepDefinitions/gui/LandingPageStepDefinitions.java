package stepDefinitions.gui;

import io.cucumber.java.en.Given;
import org.testng.Assert;
import pageobjects.LandingPage;
import testutils.contexts.TestsContext;

public class LandingPageStepDefinitions {

    TestsContext testsContext;
    LandingPage landingPage;

    public LandingPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.landingPage = testsContext.getPageObjectManager().getLandingPage();
    }

    @Given("User is on the landing page")
    public void user_is_on_the_landing_page() {
        Assert.assertTrue(landingPage.checkIfStartButtonIsVisible());
    }


}
