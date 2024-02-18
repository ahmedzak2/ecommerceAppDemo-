Feature: Customer buys product

 Scenario Outline: Customer buys the first highest priced product
    Given the customer is on the product page
    When the customer filters the products by price
   And the customer chooses the first highest priced item
    And  customer choose the second highest priced item
    And  customer open the cart
    Then the total cost of items shown is equal to total calculated  items
      And customer processed to checkOut page
    And the customer enters username "<username>" and password "<password>"
Examples:
  | username | password |
  |       userName   |    password      |