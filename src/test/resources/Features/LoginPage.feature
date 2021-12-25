@Login
Feature: Login page feature

  @Smoke
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "Login - My Stores"

  @Smoke
  Scenario: Forgot password link
    Given user is on login page
    Then forgot your password link should be displayed

  @Regression
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "dec2020secondbatch@gmail.com"
    And user enters password "Selenium@12345"
    And user clicks on login button
    Then user gets the title of the page
    And page title should be "My account - My Store"

  @Regression
  Scenario: Login without username or password
    Given user is on login page
    And user clicks on login button
    Then it should display invalid message "An email address required."

  @Regression
  Scenario: Login without password
    Given user is on login page
    When user enters username "dec2020secondbatch@gmail.com"
    And user clicks on login button
    Then it should display invalid message "Password is required."

  @Regression
  Scenario: Login without username
    Given user is on login page
    And user enters password "Selenium@12345"
    And user clicks on login button
    Then it should display invalid message "An email address required."

  @Regression
  Scenario: Login with invalid credentials
    Given user is on login page
    When user enters username "dec2020sdbatch@gmail.com"
    And user enters password "Seleum@12345"
    And user clicks on login button
    Then it should display invalid message "Authentication failed."

  @Regression
  Scenario: Login with invalid password
    Given user is on login page
    When user enters username "dec2020secondbatch@gmail.com"
    And user enters password "Selenium@12"
    And user clicks on login button
    Then it should display invalid message "Authentication failed."

  @Regression
  Scenario: Login with invalid username
    Given user is on login page
    When user enters username "dec2020secoatch@gmail.com"
    And user enters password "Selenium@12345"
    And user clicks on login button
    Then it should display invalid message "Authentication failed."

  @Regression
  Scenario: Login with wrong username format
    Given user is on login page
    When user enters username "dec2020secoatch@gmailcom"
    And user clicks on login button
    Then it should display invalid message "Invalid email address."

  @Smoke
  Scenario: Create new account without email address
    Given user is on login page
    And user click on create an account button
    Then it should display invalid email message "Invalid email address."

  @Smoke
  Scenario: Create new account with wrong email address
    Given user is on login page
    When user enters email address "wrong.email"
    And user click on create an account button
    Then it should display invalid email message "Invalid email address."