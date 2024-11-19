package stepDefinitions.gui;

import io.cucumber.java.After;
import testutils.contexts.GuiTestContext;

public class Hooks {

    GuiTestContext guiTestContext;

    public Hooks(GuiTestContext guiTestContext) {
        this.guiTestContext = guiTestContext;
    }

    @After
    public void tearDown(){
        if(guiTestContext.baseTest.driver!=null){
            guiTestContext.baseTest.driver.quit();
        }
    }
}
