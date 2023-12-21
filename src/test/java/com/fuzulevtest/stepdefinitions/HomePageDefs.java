package com.fuzulevtest.stepdefinitions;

import com.fuzulev.pages.HomePage;
import com.fuzulev.utilities.BasePage;
import com.fuzulev.utilities.DataHolder;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

/**
 * @author : user
 * @created : 21.12.2023,11:59
 * @Email :aliyeidiris@gmail.com
 **/
public class HomePageDefs extends BasePage {
    HomePage homePage=new HomePage(driver);
    @Given("user is on the application homepage")
    public void userIsOnTheApplicationHomepage() {
        Assert.assertTrue(homePage.verifyHomepage());
    }

    @When("user enters property name in the search field")
    public void userEntersPropertyNameInTheSearchField() {
        homePage.entePropertyName(DataHolder.propertyName());
    }

    @Then("user should be able to see the property")
    public void userShouldBeAbleToSeeTheProperty() {
        homePage.verifySearchResult();
    }

    @When("user apply filters to the property options")
    public void userApplyFiltersToThePropertyOptions() {
        userEntersPropertyNameInTheSearchField();
        homePage.applyFiltersToTheSearch(String.valueOf(DataHolder.minimumPrice),String.valueOf(DataHolder.maximumPrice));
    }

    @Then("user should be able see the property based on the filters")
    public void userShouldBeAbleSeeThePropertyBasedOnTheFilters() {
        homePage.verifyFilterAction();
    }
}
