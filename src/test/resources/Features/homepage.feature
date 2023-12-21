@UITest
  Feature: Home Page search properties features
    Background:
      Given user is on the application homepage

    Scenario: A user should be able to search a property on the UI
      When user enters property name in the search field
      Then user should be able to see the property

      Scenario: A user should be able filter property by types
        When user apply filters to the property options
        Then user should be able see the property based on the filters
