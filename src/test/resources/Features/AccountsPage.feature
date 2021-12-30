@AccountPage
Feature: Account page feature

  Background:
    Given user has already logged in to application
      | username                     | password       |
      | dec2020secondbatch@gmail.com | Selenium@12345 |

  @Smoke
  Scenario: account page title
    Given user is on account page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  @Regression
  Scenario: account section count
    Given user is on account page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And accounts section count should be 7