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
    Then user validates items in the cart

    When user proceeds to checkout page
    Then user validates navigation to the shipping info page

#    When user fills up shipping info "email address" field with "emman+test1@gmail.com"
    When user fills up shipping info email field with unique email
    And user fills up shipping info "first name" field with "fname"
    And user fills up shipping info "last name" field with "lname"
    And user fills up shipping info "company" field with "compname"
    And user fills up shipping info "street address" field with "street A"
    And user fills up shipping info "city" field with "city B"
    And user fills up shipping info "state" field with "Texas"
    And user fills up shipping info "zip code" field with "12034"
    And user fills up shipping info "country" field with "United States"
    And user fills up shipping info "phone number" field with "123456789"

    And user selects the "Flat Rate" shipping method
    And user clicks next button to the review page
    Then user validates shipping info

    When user clicks place order
    Then user validates order is successful

    When user clicks create a new account
    Then user validates navigation to Sign Up page
    And user validates saved information is correct
    When user enters the password "Tester@123"
    And user enters the confirm password "Tester@123"
    And user clicks Create Account
    Then user validates account creation
    And user validates order is in the list

  Scenario: Log in and proceed with shopping to checkout
    Given user opens the site

    When user opens the sign in page
    And user enters the sign in email "leunammeu23@gmail.com"
    And user enters the sign in password "Test1234"
    And user clicks the sign in button
    And user searches for "Tee"
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
    Then user validates items in the cart

    When user proceeds to checkout page
    Then user validates navigation to the shipping info page

    When user selects the "Flat Rate" shipping method
    And user clicks next button to the review page
    And user clicks place order
    Then user validates order is successful
