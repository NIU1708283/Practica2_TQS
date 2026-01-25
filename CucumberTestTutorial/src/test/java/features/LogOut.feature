Feature: Swag Labs Logout Functionality

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"

  Scenario: Successful logout from the products page
    When I open the sidebar menu
    And I select the "Logout" option
    Then I should be redirected to the login page
    And I should not be able to return to the "Products" page by navigating back