
@login
Feature: Smart bear login

  Scenario: Verify ling functionality
    Given User is on smart bear login page
    When User enter username and password
    And User clicks on login button
    Then User should be logged in successfully