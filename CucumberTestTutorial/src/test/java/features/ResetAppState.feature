Feature: Reset Application State

  Background: 
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"
    And I add the product "Sauce Labs Backpack" to the cart

  Scenario: Resetting the app state should clear the shopping cart
    When I open the sidebar menu
    And I select the "Reset App State" option
    Then the cart counter should not be displayed