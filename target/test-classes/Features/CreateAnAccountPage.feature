Feature: Create an account

  @Smoke
  Scenario: Create new account with valid email address
    Given user is on login page
    When user enters email address "roymiller018@yopmail.com"
    And user click on create an account button
    Then register page title should be "Create an account"