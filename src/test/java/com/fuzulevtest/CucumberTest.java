package com.fuzulevtest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author : user
 * @created : 21.12.2023,00:39
 * @Email :aliyeidiris@gmail.com
 **/
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber-testReport.html", "junit:target/cucumber-results.xml" },
        features = {"classpath:Features/homepage.feature"},
        tags="@UITest"
)
public class CucumberTest {
}
