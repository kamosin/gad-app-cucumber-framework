package testutils.contexts;

import api.RequestManager;
import api.models.UserRequest;
import pageobjects.PageObjectManager;
import testutils.GuiBaseTest;

import java.util.HashMap;
import java.util.Map;

public class TestsContext {

    private GuiBaseTest baseTest;
    private PageObjectManager pageObjectManager;
    private Map<String, UserRequest> users;
    private RequestManager requestManager;


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

    public GuiBaseTest getBaseTest() {
        return baseTest;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public Map<String, UserRequest> getUsers() {
        return users;
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }

}
