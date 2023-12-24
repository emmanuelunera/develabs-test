Feature: End to End Tests

  Scenario: Add multiple items, proceed to checkout before logging in
    Given user opens the site

    When user searches for "Tee"
    Then user validate search results
    When user opens the "Layla Tee" item
    And user sets the item size to "XS"
    And user sets the item color to "Blue"
    And user sets the item quantity to "1"
    And user adds item to cart
    Then user validates count of items in the cart

    When user searches for "Jacket"
    Then user validate search results
    When user opens the "Lando Gym Jacket" item
    And user sets the item size to "M"
    And user sets the item color to "Green"
    And user sets the item quantity to "2"
    And user adds item to cart
    Then user validates count of items in the cart

    When user searches for "Yoga"
    Then user validate search results
    When user opens the "Josie Yoga Jacket" item
    And user sets the item size to "XS"
    And user sets the item color to "Blue"
    And user sets the item quantity to "3"
    And user adds item to cart
    Then user validates count of items in the cart

    When user opens the cart menu
    When user proceeds to checkout page
    Then user validates navigation to the shipping info page

#    When user fills up shipping info "email address" field with "emman+test1@gmail.com"
    When user fills up shipping info email field with unique email
    When user fills up shipping info "first name" field with "fname"
    When user fills up shipping info "last name" field with "lname"
    When user fills up shipping info "company" field with "compname"
    When user fills up shipping info "street address" field with "street A"
    When user fills up shipping info "city" field with "city B"
    When user fills up shipping info "state" field with "Texas"
    When user fills up shipping info "zip code" field with "12034"
    When user fills up shipping info "country" field with "United States"
    When user fills up shipping info "phone number" field with "123456789"

    When user selects the "Flat Rate" shipping method
    When user clicks next button to the review page

    When user clicks place order
