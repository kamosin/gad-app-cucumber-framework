package stepDefinitions.gui;

import api.ArticlesService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageobjects.NavigationBar;
import pageobjects.articles.ArticlesPage;
import pageobjects.articles.NewArticleModal;
import testutils.ReusableData;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

import java.util.List;

public class ArticlesPageStepDefinitions {

    TestsContext testsContext;
    NavigationBar navigationBar;
    ArticlesPage articlesPage;
    NewArticleModal newArticleModal;
    ArticlesService articlesApi;

    public ArticlesPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.navigationBar = testsContext.getPageObjectManager().getNavigationBar();
        this.articlesPage = testsContext.getPageObjectManager().getArticlesPage();
        this.articlesApi = new ArticlesService(testsContext.getRequestManager());
    }

    @When("User inputs the data into new article form")
    public void userInputsTheDataIntoNewArticleForm(List<String> data) {
        testsContext.setNumberOfArticles(articlesApi.getNumberOfArticles());
        navigationBar.clickArticlesPageButton();
        newArticleModal = navigationBar.clickAddArticleButton();
        newArticleModal.enterAllData(data.getFirst(), data.getLast(), ReusableData.articlePictureName);
        newArticleModal.clickSaveButton();
    }

    @And("Number of created articles is increased by {int}")
    public void numberOfCreatedArticlesIsIncreasedBy(int increaseNumber) {
        Assert.assertEquals(articlesApi.getNumberOfArticles(), testsContext.getNumberOfArticles()+increaseNumber);
    }

    @When("User inputs only title into new article form")
    public void userInputsOnlyTitleIntoNewArticleForm() {
        var randomTitle = TestDataGenerator.generateText(15);
        navigationBar.clickArticlesPageButton();
        newArticleModal = navigationBar.clickAddArticleButton();
        newArticleModal.enterTitle(randomTitle);
        newArticleModal.clickSaveButton();
        testsContext.setNumberOfArticles(articlesApi.getNumberOfArticles());
    }

    @When("User clears title field and inputs only body into new article form")
    public void userClearsTitleFieldAndInputsOnlyBodyIntoNewArticleForm() {
        var randomBody = TestDataGenerator.generateText(50);
        newArticleModal.clearTitle();
        newArticleModal.enterBody(randomBody);
        newArticleModal.clickSaveButton();
        testsContext.setNumberOfArticles(articlesApi.getNumberOfArticles());
    }

    @Then("Button to add new article is not visible")
    public void buttonToAddNewArticleIsNotVisible() {
        Assert.assertFalse(navigationBar.isAddArticleButtonVisible());
    }
}
