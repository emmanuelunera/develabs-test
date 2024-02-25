Feature: Product Browsing Tests

  Scenario: Validate Successful Search Results
    Given user opens the site
    When user searches for "Tee"
    Then user validate search results

  Scenario: Validate Search for non-existing item
    Given user opens the site
    When user searches for "Volvo"
    Then user validate search results
