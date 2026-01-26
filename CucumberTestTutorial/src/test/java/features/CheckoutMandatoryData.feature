Feature: Checkout Mandatory Data Validation

  Background:
    Given I am on the Swag Labs login page
    And I login with user "standard_user" and password "secret_sauce"
    And I add the product "first" to the cart
    And I go to the cart
    And I click on the "Checkout" button

  Scenario Outline: Verify error messages for missing mandatory data
    When I enter the first name "<first_name>", last name "<last_name>" and zip code "<zip_code>"
    And I click on the "Continue" button
    Then I should see an error message containing "<error_message>"

    Examples:
      | first_name | last_name | zip_code | error_message                  		    |
      |            | Doe       | 12345    | Error: First Name is required         |
      | John       |           | 12345    | Error: Last Name is required          |
      | John       | Doe       |          | Error: Postal Code is required        |