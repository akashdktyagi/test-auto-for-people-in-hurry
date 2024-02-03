Feature: As a user, I want to test google search page

    Scenario: As a user, I want to search "Computer" in google search page
        Given I have a browser opened
        When I navigate to url
        And I search "Computer"
        Then I expect to see "Computer" in search result

    Scenario: As a user, I want to search "Selenium" in google search page
        Given I have a browser opened
        When I navigate to url
        And I search "Selenium"
        Then I expect to see "Selenium" in search result

    Scenario: As a user, I want to search "Cucumber" in google search page
        Given I have a browser opened
        When I navigate to url
        And I search "Cucumber"
        Then I expect to see "Cucumber" in search result

    Scenario: As a user, I want to search "Jenkins" in google search page
        Given I have a browser opened
        When I navigate to url
        And I search "Jenkins"
        Then I expect to see "Jenkins" in search result                        

