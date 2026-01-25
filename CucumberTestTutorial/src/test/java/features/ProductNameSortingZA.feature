Feature: Product Sorting by Name (Z-A)

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Sort products by name in descending order
    When I sort the products by "Name (Z to A)"
    Then the products should be sorted alphabetically from Z to A