package testutils.contexts;

import pageobjects.PageObjectManager;
import testutils.GuiBaseTest;

public class GuiTestContext {

    public GuiBaseTest baseTest;
    public PageObjectManager pageObjectManager;

    public GuiTestContext() {
        baseTest = new GuiBaseTest();
        pageObjectManager = new PageObjectManager(baseTest.getDriver());
    }
}
