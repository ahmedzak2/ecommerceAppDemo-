Feature: Customer buys product

  Scenario: Customer buys the first highest priced product
    Given the customer is on the product page
    When the customer filters the products by price
    And the customer chooses the first highest priced item
    Then the result should meet expectations
