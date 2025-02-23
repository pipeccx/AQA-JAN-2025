Feature: Search for a phone and save to database

Scenario: Get iPhone name and price and save to DB
    Given I open the browser and navigate to "https://allo.ua"
    When I search for "Iphone"
    Then I extract phone name and price
    And I save phone name and price to the database
    And I print the phone details to the console