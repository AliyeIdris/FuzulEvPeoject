@ApiTest
Feature: Api Test
  Background:
    Given user has the authentication information to connect to the Api
  Scenario:  An authorized user should be able to get a list of properties by sending a get request to the API
    When the user send a get request to the properties endpoint
    Then the api should return 200 response code
    And api should return more then one property


    Scenario: The API should return an empty collection when no matching property found
