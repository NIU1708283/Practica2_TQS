Feature: Product Sorting by Price (Low to High)

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Sort products by price from low to high
    When I sort the products by "Price (low to high)"
    Then the products should be sorted by price from low to high