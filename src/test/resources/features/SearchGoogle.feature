Feature: As a user, I want to test google search page

    Scenario: As a user, I want to search "Computer" in google search page
        Given I have a browser opened
        When I navigate to url
        When I search "Computer"
        Then I expect to see "Computer" in search result

