package com.fuzulevtest.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static com.fuzulev.utilities.FunctionUtility.readConfig;

/**
 * @author : user
 * @created : 21.12.2023,22:24
 * @Email :aliyeidiris@gmail.com
 **/
public class ApiSteps {
    Scenario scenario;
    Response response;
    String host=readConfig("api_host");
    int port=Integer.parseInt(readConfig("api_port1"));
    String username=readConfig("api_username");
    String password=readConfig("api_password");

    @Before
    public void beforeStep(Scenario scenario) {
        this.scenario = scenario;
        RestAssured.baseURI=host;
        RestAssured.port=port;
        RestAssured.authentication=(RestAssured.basic(username,password));
    }
    @Given("user has the authentication information to connect to the Api")
    public void userHasTheAuthenticationInformationToConnectToTheApi() {
        scenario.log("Api username: "+username);
        scenario.log("Api password: "+password);
    }

    @When("the user send a get request to the properties endpoint")
    public void theUserSendAGetRequestToThePropertiesEndpoint() {
    }

    @Then("the api should return {int} response code")
    public void theApiShouldReturnResponseCode(int arg0) {
    }

    @And("api should return more then one property")
    public void apiShouldReturnMoreThenOneProperty() {
    }
}
