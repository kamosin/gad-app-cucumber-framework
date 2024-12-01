package testutils.contexts;

import api.RequestManager;
import api.models.UserRequest;
import io.restassured.response.Response;
import pageobjects.CommonComponent;
import pageobjects.PageObjectManager;
import testutils.GuiBaseTest;

import java.util.HashMap;
import java.util.Map;

public class TestsContext {

    private GuiBaseTest baseTest;
    private PageObjectManager pageObjectManager;
    private CommonComponent commonComponent;
    private Map<String, UserRequest> users;
    private RequestManager requestManager;
    private int numberOfArticles;
    private String flashpostText;
    private Response userResponse;


    public TestsContext() {
        this.users = new HashMap<>();
    }

    public void setupRequestManager() {
        this.requestManager = new RequestManager();
    }

    public void setupBaseTest() {
        this.baseTest = new GuiBaseTest();
    }

    public void setupPageObjectManager() {
        this.pageObjectManager = new PageObjectManager(baseTest.getDriver());
    }

    public void setupCommonComponent() {
        this.commonComponent = new CommonComponent(baseTest.getDriver());
    }

    public GuiBaseTest getBaseTest() {
        return baseTest;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public CommonComponent getCommonComponent() {
        return commonComponent;
    }

    public Map<String, UserRequest> getUsers() {
        return users;
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }

    public int getNumberOfArticles() {
        return numberOfArticles;
    }

    public void setNumberOfArticles(int numberOfArticles) {
        this.numberOfArticles = numberOfArticles;
    }

    public String getFlashpostText() {
        return flashpostText;
    }

    public void setFlashpostText(String flashpostText) {
        this.flashpostText = flashpostText;
    }

    public Response getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(Response userResponse) {
        this.userResponse = userResponse;
    }
}
