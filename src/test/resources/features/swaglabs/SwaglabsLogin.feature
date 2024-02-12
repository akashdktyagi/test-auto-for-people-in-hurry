@swaglabs
Feature: As a user I want to login to Swag labs application, 
         so that I can order products

@t
Scenario: Successful login with valid credentials
    Given I am on the Swaglabs login page
    When I enter valid username and password
     |username     |password    | 
     |standard_user|secret_sauce|
    And I click on the login button
    Then I should be logged in successfully


Scenario Outline: I should not be able to login with invalid credentials
    Given I am on the Swaglabs login page
    When I enter invalid username and password
     |username     |password    | 
     |<username>   |<password>  |
    And I click on the login button
    Then I should see an error message ""

    Examples:
        |   username  |  password  |
        |invalid_user |invalid_pass|
        |standard_user|invalid_pass|
        |invalid_user |secret_sauce|
        |standard_user|invalid_pass|