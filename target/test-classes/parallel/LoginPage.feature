@Login
Feature: Login page feature
  @Smoke
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Swag Labs"
  @Smoke
  Scenario: Login Page logo
    Given user is on login page
    Then log in page logo should be displayed
  @Regression @skip_scenario
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "standard_user"
    And user enters password "secret_sauce"
    And user clicks on Login button
    Then user gets the title of the my account page
    And my account page title should be "Swag Labs"