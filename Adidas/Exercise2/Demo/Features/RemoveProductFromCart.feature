
@tag
Feature: Remove product from cart
  The user wants to remove a product from cart



  @remove
  Scenario Outline: Remove product from chart
    Given a cart with <productName> and <productName2>
    When user delete <productName2> from cart
    Then the <productName2> must be removed from the cart
    But the <productName> must still on the cart


    Examples: 
      | productCategory  | productName   | productName2 |
			| Laptops          | Sony vaio i5  | Dell i7 8gb  |
