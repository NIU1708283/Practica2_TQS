Feature: Product Sorting by Name (A-Z)

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Sort products by name in ascending order
    When I sort the products by "Name (A to Z)"
    Then the products should be sorted alphabetically from A to Z