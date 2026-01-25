
Feature: Swag Labs Authentication

  Background:
    Given I am on the Swag Labs login page

  Scenario: Login with valid credentials
    When I login with user "standard_user" and password "secret_sauce"
    Then I should be redirected to the "Products" page

  Scenario: Login with a locked out user
    When I login with user "locked_out_user" and password "secret_sauce"
    Then I should see an error message containing "Sorry, this user has been locked out"