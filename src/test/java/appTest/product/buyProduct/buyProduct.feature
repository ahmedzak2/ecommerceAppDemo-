Feature: Customer buys product

  Scenario Outline: Customer buys the first highest priced product
    Given the customer is on the product page
    When the customer filters the products by price
    And the customer chooses the first highest priced item
    And  customer choose the second highest priced item
    And  customer open the cart
    Then the total cost of items shown is equal to total calculated  items
    When customer processed to checkOut page to buy product
    And the customer enters username "<username>" and password "<password>"
    And the customer enters fullname "<fullName>"
    And the customer enters address "<addresslin1>" and address "<addresslin2>"
    And the customer enters city "<city>" and region "<state>" and zipCode "<zipCode>" and Country "<country>"
    Then customer click on to payment
    And the customer enters fullname written on card  "<fullName>"
    And The customer enter cardNumber "<cardNumber>"
    And The customer enter expire date  "<date>"
    And The customer enter security code  "<code>"
    And the customer click on review order
    # cardNumber 3258 1265 7568 789
    Examples:
      | username | password | fullName | addresslin1 | addresslin2 | city | state | zipCode | country | cardNumber | date | code |
      | userName | password | fullName | addresslin1 | addresslin2 | city | state | zipCode | country | cardNumber | date |   code   |