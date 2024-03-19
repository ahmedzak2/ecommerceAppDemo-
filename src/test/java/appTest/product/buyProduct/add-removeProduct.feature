Feature: Customer add or remove item form cart log

  Scenario Outline: Customer add item to cart
    Given the customer is on the product page
    When the customer filters the products by price
    And the customer chooses the first highest priced item
    And  customer choose the second highest priced item
    And  customer open the cart
    Then the total cost of items shown is equal to total calculated  items
    And The customer add items "<numberOfItems>"for one"<indexOfProduct>" of product
    Then the number of item is added "<numberOfItems>" successfully to "<indexOfProduct>" product
    When customer processed to checkOut page to buy product

    Examples:
      | indexOfProduct | numberOfItems |
      | 1              | 2             |

  Scenario Outline: Customer remove  item form cart cart
    Given the customer is on the product page
    When the customer filters the products by price
    And the customer chooses the first highest priced item
    And  customer choose the second highest priced item
    And  customer open the cart
    Then the total cost of items shown is equal to total calculated  items
    And The customer add items "<numberOfItems>"for one"<indexOfProduct>" of product
    Then the number of item is added "<numberOfItems>" successfully to "<indexOfProduct>" product
    And cumstomer remove itmes "<numberOfRemovedItems>"for one"<indexOfProduct>" of product
    Then the number of item is removed  "<numberOfRemovedItems>" successfully to "<indexOfProduct>" product
    When customer processed to checkOut page to buy product

    Examples:
      | indexOfProduct | numberOfItems | numberOfRemovedItems |
      | 1              | 4             | 1                    |