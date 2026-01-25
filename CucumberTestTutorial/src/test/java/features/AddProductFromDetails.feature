Feature: Add product to cart from details page

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Successfully add a product to the cart from its details page
    When I click on the name of the product "Sauce Labs Backpack"
    And I click the "Add to cart" button on the details page
    Then the cart counter should show "1"