Feature: Checkout product

  Scenario: User want to checkout product item
    Given User opened google chrome browser
    When User opened luna website to sign in
    And User click on sign in button
    And User fill out email and password
    And User go to men catalogue and select product
    And User go to order summary
    Then User select payment method
    And User finish to payment
