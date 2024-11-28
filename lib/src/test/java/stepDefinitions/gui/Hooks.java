package stepDefinitions.gui;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testutils.contexts.TestsContext;

public class Hooks {

    TestsContext testsContext;

    public Hooks(TestsContext testsContext) {
        this.testsContext = testsContext;
    }

    @Before("@GUI")
    public void guiSetup(){
        this.testsContext.setupBaseTest();
        this.testsContext.setupPageObjectManager();
    }

    @Before("@API")
    public void apiSetup(){
        this.testsContext.setupRequestManager();
    }

    @After("@GUI")
    public void tearDown(){
        if(testsContext.getBaseTest().driver!=null){
            testsContext.getBaseTest().driver.quit();
        }
    }
}
