Feature: Shopping Cart Tests

  Scenario: Add item and validate cart contents
    Given user opens the site
    When user searches for "Tee"
    Then user validate search results
    When user opens the "Layla Tee" item
    And user sets the item size to "XS"
    And user sets the item color to "Blue"
    And user sets the item quantity to "1"
    And user adds item to cart
    Then user validates count of items in the cart
    When user opens the cart menu
    Then user validates items in the cart
