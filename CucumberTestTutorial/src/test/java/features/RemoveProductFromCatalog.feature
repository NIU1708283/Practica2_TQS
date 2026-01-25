Feature: Remove products from catalog

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Remove an added product from the inventory page
    When I add the product "Sauce Labs Backpack" to the cart
    And I remove the product "Sauce Labs Backpack" from the inventory
    Then the cart counter should not be displayed