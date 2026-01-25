
Feature: Authentication Error Management

  Background:
    Given I am on the Swag Labs login page

  Scenario Outline: Verify various login error messages
    When I login with user "<username>" and password "<password>"
    Then I should see an error message containing "<error_message>"

    Examples:
      | username          | password       | error_message                                               |
      | locked_out_user   | secret_sauce   | Sorry, this user has been locked out.                       |
      | standard_user     | wrong_password | Username and password do not match any user in this service |
      |                   | secret_sauce   | Username is required                                        |
      | standard_user     |                | Password is required                                        |