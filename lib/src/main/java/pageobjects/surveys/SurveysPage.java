package pageobjects.surveys;

import api.testutils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageobjects.CommonComponent;
import pageobjects.surveys.automationsurvey.TestAutomationSurveyPage;
import pageobjects.surveys.restapisurvey.RestApiTestingSurveyPage;
import pageobjects.surveys.statistics.AutomationStatisticsPage;
import pageobjects.surveys.statistics.RestApiStatisticsPage;

import java.util.List;
import java.util.Objects;

public class SurveysPage {

    WebDriver driver;
    CommonComponent commonComponent;

    public SurveysPage(WebDriver driver) {
        this.driver = driver;
        this.commonComponent = new CommonComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "button[translateid='btnTakeSurvey']")
    List<WebElement> takeSurveyButtons;
    @FindBy(id = "btnSurveyStatistics")
    WebElement restApiTestingStatistics;
    @FindBy(css = "button[translateid='btnSurveyStatistics']")
    WebElement automationTestingStatistics;

    public RestApiTestingSurveyPage clickRestApiTakeSurveyButton(){
        takeSurveyButtons.getFirst().click();
        return new RestApiTestingSurveyPage(driver);
    }

    public TestAutomationSurveyPage clickTestAutomationSurveyButton(){
        takeSurveyButtons.getLast().click();
        return new TestAutomationSurveyPage(driver);
    }

    public RestApiStatisticsPage clickRestApiStatisticsButton(){
        restApiTestingStatistics.click();
        return new RestApiStatisticsPage(driver);
    }

    public AutomationStatisticsPage clickAutomationStatisticsButton(){
        automationTestingStatistics.click();
        return new AutomationStatisticsPage(driver);
    }

    public boolean checkIfOnSurveysUrl() {
        var surveysPath = "/surveys.html";
        var surveysUrl = TestUtils.getGlobalValue("baseUrl") + surveysPath;
        commonComponent.waitForUrlToBeLoaded(surveysUrl);
        return Objects.equals(driver.getCurrentUrl(), surveysUrl);
    }


}
