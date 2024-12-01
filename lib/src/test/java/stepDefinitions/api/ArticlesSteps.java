package stepDefinitions.api;

import api.ArticlesService;
import api.models.ArticleRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import testutils.ReusableData;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

public class ArticlesSteps {

    TestsContext testsContext;
    ArticlesService articlesService;
    ArticleRequest articleRequest;
    Response requestResponse;

    public ArticlesSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.articlesService = new ArticlesService(testsContext.getRequestManager());
        this.requestResponse = testsContext.getRequestResponse();
    }

    @Given("Request with valid generated article data is prepared")
    public void requestWithValidGeneratedArticleDataIsPrepared() {
        articleRequest = TestDataGenerator.generateArticle();
    }


    @When("User creates new Article with prepared request")
    public void userCreatesNewArticleWithPreparedRequest() {
        requestResponse = articlesService.createArticle(articleRequest);
        testsContext.setRequestResponse(requestResponse);
    }

    @Given("Request with missing body is prepared")
    public void requestWithMissingBodyIsPrepared() {
        articleRequest = new ArticleRequest(TestDataGenerator.generateArticleTitle(), "", TestDataGenerator.currentDate(), ReusableData.articlePictureName);
    }

    @Given("Request with missing title is prepared")
    public void requestWithMissingTitleIsPrepared() {
        articleRequest = new ArticleRequest("", TestDataGenerator.generateText(50), TestDataGenerator.currentDate(), ReusableData.articlePictureName);
    }

    @Given("Request with title longer than {int} characters is prepared")
    public void requestWithTitleLongerThanCharactersIsPrepared(int numberOfCharacters) {
        articleRequest = new ArticleRequest(TestDataGenerator.generateText(numberOfCharacters+1), TestDataGenerator.generateText(100),
                TestDataGenerator.currentDate(), ReusableData.articlePictureName);
    }
}
