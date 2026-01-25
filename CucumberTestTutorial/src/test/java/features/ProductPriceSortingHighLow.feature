Feature: Product Sorting by Price (High to Low)

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Sort products by price from high to low
    When I sort the products by "Price (high to low)"
    Then the products should be sorted by price from high to low