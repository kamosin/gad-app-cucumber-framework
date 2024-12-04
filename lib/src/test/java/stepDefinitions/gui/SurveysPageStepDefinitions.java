package stepDefinitions.gui;

import api.SurveysService;
import api.testutils.TestUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;
import pageobjects.MyAccountPage;
import pageobjects.surveys.SurveysPage;
import pageobjects.surveys.automationsurvey.*;
import pageobjects.surveys.restapisurvey.*;
import testutils.contexts.TestsContext;

public class SurveysPageStepDefinitions {

    TestsContext testsContext;
    SurveysPage surveysPage;
    MyAccountPage myAccountPage;
    RestApiTestingSurveyPage restApiTestingSurveyPage;
    TestAutomationSurveyPage testAutomationSurveyPage;
    SurveysService surveysService;
    private int restApiTestingExperienceNumber;
    private int automationTestingExperienceNumber;

    public SurveysPageStepDefinitions(TestsContext testsContext) {
        this.testsContext = testsContext;
        this.surveysPage = testsContext.getPageObjectManager().getSurveysPage();
        this.myAccountPage = testsContext.getPageObjectManager().getMyAccountPage();
        this.surveysService = new SurveysService(testsContext.getRequestManager());
    }

    @And("User is on surveys page")
    public void userIsOnSurveysPage() {
        myAccountPage.clickSurveysButton();
        Assert.assertTrue(surveysPage.checkIfOnSurveysUrl());
    }

    @When("User completes the REST API survey")
    public void userCompletesTheRESTAPISurvey(DataTable dataTable) {
        this.restApiTestingExperienceNumber = Integer.parseInt(TestUtils.getJsonPath(surveysService.getRestApiSurveyStatistics(), "\"rest api testing\".yes"));
        var data = dataTable.asLists(String.class);
        var manualTestingExperience = Boolean.parseBoolean(data.getFirst().getFirst());
        var manualTestingTools = data.get(1).stream().map(ManualTestingTool::valueOf).toList();
        var newmanExperience = Boolean.parseBoolean(data.get(2).getFirst());
        var cicdExperience = Boolean.parseBoolean(data.get(3).getFirst());
        var cicdTools = data.get(4).stream().map(CiCdTool::valueOf).toList();
        var testingFrequency = FrequencyTesting.valueOf(data.get(5).getFirst());
        var testTypes = data.get(6).stream().map(TestTypes::valueOf).toList();
        var testText = data.get(7).getFirst();
        restApiTestingSurveyPage = surveysPage.clickRestApiTakeSurveyButton();
        restApiTestingSurveyPage.answerAllQuestions(manualTestingExperience, manualTestingTools, newmanExperience, cicdExperience,
                cicdTools, testingFrequency, testTypes, testText);
        restApiTestingSurveyPage.clickReturnToSurveysButton();
    }


    @And("User completes the Automation Testing Survey")
    public void userCompletesTheAutomationTestingSurvey(DataTable dataTable) {
        this.automationTestingExperienceNumber = Integer.parseInt(TestUtils.getJsonPath(surveysService.getAutomationSurveyStatistics(), "\"experience in test automation\".yes"));
        var data = dataTable.asLists(String.class);
        var automationTestingExperience = Boolean.parseBoolean(data.getFirst().getFirst());
        var yearsOfExperience = data.get(1).stream().map(YearsOfExperience::valueOf).toList();
        var testAutomationTools = data.get(2).stream().map(TestAutomationTool::valueOf).toList();
        var programmingLanguages = data.get(3).stream().map(ProgrammingLanguages::valueOf).toList();
        var numberOfAutomatedTests = NumberOfAutomatedTests.valueOf(data.get(4).getFirst());
        var testTypes = data.get(5).stream().map(TestTypes::valueOf).toList();
        var text = data.get(6).getFirst();
        testAutomationSurveyPage = surveysPage.clickTestAutomationSurveyButton();
        testAutomationSurveyPage.answerAllQuestions(automationTestingExperience, yearsOfExperience,
                testAutomationTools, programmingLanguages, numberOfAutomatedTests, testTypes, text);
        testAutomationSurveyPage.clickReturnToSurveysButton();
    }

    @Then("Automation experience statistics in statistics page is increased")
    public void automationExperienceStatisticsInStatisticsPageIsIncreased() {
        var oldNumber = automationTestingExperienceNumber;
        var newNumber = Integer.parseInt(TestUtils.getJsonPath(surveysService.getAutomationSurveyStatistics(), "\"experience in test automation\".yes"));
        Assert.assertEquals(oldNumber, newNumber -1);
    }

    @And("Rest API experience statistics are increased")
    public void restAPIExperienceStatisticsAreIncreased() {
        var oldNumber = restApiTestingExperienceNumber;
        var newNumber = Integer.parseInt(TestUtils.getJsonPath(surveysService.getRestApiSurveyStatistics(), "\"rest api testing\".yes"));
        Assert.assertEquals(oldNumber, newNumber -1);
    }

}
