Feature: Add products from catalog to cart

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Add one product to the cart
    When I add the product "Sauce Labs Backpack" to the cart
    Then the cart counter should show "1"