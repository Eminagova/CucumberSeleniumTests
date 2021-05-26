Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given browser is opened
    And user is on the login page
    When user enters email address and password
    And click on the sign in button
    Then user is navigated to the my account page
    
    