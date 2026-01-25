Feature: Product Details Navigation

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Navigate to product details by clicking on the name
    When I click on the name of the product "Sauce Labs Backpack"
    Then I should see the details page for "Sauce Labs Backpack"

  Scenario: Navigate to product details by clicking on the image
    When I click on the image of the product "Sauce Labs Bolt T-Shirt"
    Then I should see the details page for "Sauce Labs Bolt T-Shirt"