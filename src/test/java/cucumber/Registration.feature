Feature: Successful User Registration with valid credentials
  Scenario: Register a new user
    Given User is on the registration page
    When User enters valid registration details
    And User clicks on the submit button
    Then User should be registered successfully
    
