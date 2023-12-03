
Feature: Smart bear login

  Background:
    Given User is on smart bear login page



  @test1
  Scenario: Verify login functionality
    When User enters username "Tester" and password "test"
    And User clicks on login button
    Then User should be logged in successfully




  Scenario Outline: Verify login functionality with different credentials

    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should be logged in successfully

    Examples:
      |username|password|
      |Testing | test1  |
      |abc     |abc1    |
      |Tester  | test   |
      |java    |java    |
      |Tester  |test    |