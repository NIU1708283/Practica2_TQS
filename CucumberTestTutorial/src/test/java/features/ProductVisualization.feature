Feature: Product Visualization

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: All products in the catalog are displayed with complete information
    Then I should see that all products have a name, a price, and an image