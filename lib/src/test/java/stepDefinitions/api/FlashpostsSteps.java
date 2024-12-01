package stepDefinitions.api;

import api.FlashpostsService;
import api.models.flashpost.FlashpostRequest;
import api.models.flashpost.FlashpostSettings;
import api.testutils.TestUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import testutils.TestDataGenerator;
import testutils.contexts.TestsContext;

import java.util.List;

public class FlashpostsSteps {

    TestsContext testsContext;
    FlashpostsService flashpostsService;
    FlashpostRequest flashpostRequest;
    Response requestResponse;

    public FlashpostsSteps(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.flashpostsService = new FlashpostsService(testsContext.getRequestManager());
        this.requestResponse = testsContext.getRequestResponse();
    }

    @When("User reads all flashposts using API")
    public void userReadsAllFleshpostsUsingAPI() {
        requestResponse = flashpostsService.getFlashposts();
        testsContext.setRequestResponse(requestResponse);
    }

    @Given("Request with valid generated flashpost data is prepared")
    public void requestWithValidFlaspostDataIsPrepared() {
        flashpostRequest = new FlashpostRequest(TestDataGenerator.generateText(50), new FlashpostSettings("#dddfff"), false);
    }

    @Given("Request with valid flashpost data is prepared")
    public void requestWithValidFlaspostDataIsPrepared(List<String> data) {
        var flashpostText = data.getFirst();
        var isPublic = data.getLast().equals("public");
        flashpostRequest = new FlashpostRequest(flashpostText, new FlashpostSettings(data.get(1)), isPublic);
    }

    @Given("Request with too long flashpost data is prepared")
    public void requestWithTooLongFlashpostDataIsPrepared() {
        flashpostRequest = new FlashpostRequest("Automatyzuj testy z Playwright i Git! Zwiększ efektywność, wdrażaj szybciej i poprawiaj jakość kodu. Przyszłość IT w twoich rękach!", new FlashpostSettings(null), true);
    }

    @When("User creates new flashpost with prepared request")
    public void userCreatesNewFlashpostWithPreparedRequest() {
        testsContext.setNumberOfFlashposts(flashpostsService.getNumberOfFlashposts());
        requestResponse = flashpostsService.createFlashpost(flashpostRequest);
        testsContext.setRequestResponse(requestResponse);
    }

    @And("Number of created flashposts is increased by {int}")
    public void numberOfCreatedFlashpostsIsIncreasedBy(int increasedNumber) {
        Assert.assertEquals(flashpostsService.getNumberOfFlashposts(), testsContext.getNumberOfFlashposts()+increasedNumber);
    }

    @And("User tries to get created flashpost")
    public void userTriesToGetCreatedFlashpost() {
        testsContext.setRequestResponse(flashpostsService.getFlashpostsById(Integer.parseInt(TestUtils.getJsonPath(testsContext.getRequestResponse(), "id"))));
    }

    @Then("Response body contains flashpost text")
    public void responseBodyContainsFlashpostText() {
        Assert.assertEquals(TestUtils.getJsonPath(testsContext.getRequestResponse(), "body"), flashpostRequest.body());
    }
}
