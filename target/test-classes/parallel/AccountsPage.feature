Feature: Account Page Feature

  Background:
    Given user has already logged in to application
      |username|password|
      |standard_user|secret_sauce|

  @accounts
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "Swag Labs"

  @accounts
  Scenario: Accounts page products sort by lowest price
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "Swag Labs"
    Then user displayed products sort items
    Then user select lowest price sort from products sort items

  @accounts
  Scenario: Accounts section count
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "Swag Labs"
    Then user add items to the shopping cart
    Then visit to the shopping cart
    Then remove an item and then continue shopping
    Then add another item
    Then checkout


