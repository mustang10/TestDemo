
@tag
Feature: Add product to cart
  The user wants to buy a new product

  @add
  Scenario Outline: Add product to cart
    Given user navigates to demoblaze home page
    When user navigate to categories
    And select <productCategory>
    And select <productName>
    And add the product to cart
    Then a popup (Product added) must be shown
    And the <productName> must be on the cart
    And the number of products in cart must be 1


    Examples: 
      | productCategory  | productName   | 
      | Laptops          | Sony vaio i5  |       