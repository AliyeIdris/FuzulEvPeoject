package com.fuzulevtest;

import com.fuzulev.utilities.BasePage;
import com.fuzulev.utilities.DriverType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.fuzulev.utilities.FunctionUtility.readConfig;

/**
 * @author : user
 * @created : 21.12.2023,00:39
 * @Email :aliyeidiris@gmail.com
 **/
public class Hooks extends BasePage {
    @Before
    public void setUp(Scenario scenario) {
        if (scenario.getSourceTagNames().contains("@UITest")) {
            scenario.log("UI test started...");
            setUp(DriverType.CHROME_DRIVER, readConfig("uiUrl"));
        } else if (scenario.getSourceTagNames().contains("@Api")) {
            scenario.log("Api test started...");
        }
    }
    @After("@UITest")
    public void tearDownBrowser(Scenario scenario) {
        scenario.log("UI test ended!");
        closeBrowser();
    }
    @After("@Api")
    public void tearDownDatabase(Scenario scenario) {
        scenario.log("Api test ended!");
    }
}
