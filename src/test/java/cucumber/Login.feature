Feature: User Login
  Scenario: Login with valid credentials
    Given User is on the login page
    When User enters valid login details
    And User clicks on the login button
    Then User should be logged in successfully