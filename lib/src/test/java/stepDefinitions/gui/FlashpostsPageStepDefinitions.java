package stepDefinitions.gui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.NavigationBar;
import pageobjects.flashposts.FlashpostsPage;
import pageobjects.flashposts.NewFlashpostModal;
import testutils.contexts.TestsContext;

import java.util.List;

public class FlashpostsPageStepDefinitions {

    TestsContext testsContext;
    NavigationBar navigationBar;
    FlashpostsPage flashpostsPage;
    NewFlashpostModal newFlashpostModal;

    public FlashpostsPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.navigationBar = testsContext.getPageObjectManager().getNavigationBar();
    }

    @When("User inputs the data into flashpost creation modal")
    public void userInputsTheDataIntoFlashpostCreationModal(List<String> data) {
        flashpostsPage = navigationBar.clickFlashpostsPageButton();
        newFlashpostModal = flashpostsPage.clickCreateFlashpostsButton();
        newFlashpostModal.enterFlashpostData(data.getFirst());
        newFlashpostModal.setBackgroundColor(data.getLast());
        newFlashpostModal.clickCreateButton();
    }

    @And("Flashpost author's name {string} and surname is displayed on top of flashposts")
    public void flashpostAuthorSNameAndSurnameIsDisplayedOnTopOfFlashposts(String name) {
        var author = testsContext.getUsers().get(name);
        Assert.assertEquals(flashpostsPage.getFlashpostAuthor(0), author.firstname() + " " + author.lastname());
    }

    @And("User creates new flaspost with empty message")
    public void userCreatesNewFlaspostWithEmptyMessage() {
        flashpostsPage = navigationBar.clickFlashpostsPageButton();
        newFlashpostModal = flashpostsPage.clickCreateFlashpostsButton();
        newFlashpostModal.clickCreateButton();
    }
}
