Feature: Complete Checkout Success Flow

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"
    And I add the product "Sauce Labs Backpack" to the cart

  Scenario: Complete a purchase successfully
    And I go to the cart
    And I click on the "Checkout" button
    And I enter the first name "John", last name "Doe" and zip code "12345"
    And I click on the "Continue" button
    When I click on the "Finish" button
    Then I should see the confirmation message "THANK YOU FOR YOUR ORDER"