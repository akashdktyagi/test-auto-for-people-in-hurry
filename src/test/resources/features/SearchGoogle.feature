Feature: As a user, I want to test google search page

    Background:
        Given I have a browser opened
        When I navigate to url

    Scenario: As a user, I want to search "Selenium" in google search page
        When I search "Selenium"
        Then I expect to see "Selenium" in search result

    Scenario: As a user, I want to search "Jenkins" in google search page
        When I search "Jenkins"
        Then I expect to see "Jenkins" in search result

    Scenario: As a user, I want to search "Satya" in google search page
        When I search "Satya"
        Then I expect to see "Satya" in search result

    Scenario: As a user, I want to search "TCS" in google search page
        When I search "TCS"
        Then I expect to see "TCS" in search result

    Scenario: As a user, I want to search "Akash" in google search page
        When I search "Akash"
        Then I expect to see "Akash" in search result


