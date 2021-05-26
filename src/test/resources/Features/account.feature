Feature: Test create an account

  Scenario: Check registration is successful with valid data
    Given browser is open
    And user is on the authentication page
    When user enters email
    And click on the create an account button
    Then user is navigated to the create an account page
    And fill all required fields
    Then user should be successfully created
    