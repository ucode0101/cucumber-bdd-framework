Feature: Login feature feature


  Scenario Outline: Verify login functionality with different credentials
    Given User is on smart bear login page
    When User enters username "<username>" and password "<password>"
    And User clicks on login button
    Then User should be logged in successfully

    Examples:
      | username | password |
      | Testing  | test1    |
      | abc      | abc1     |
      | Tester   | test     |
      | java     | java     |
      |Tester  |test    |