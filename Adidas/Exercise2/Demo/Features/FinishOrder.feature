
@tag
Feature: Finish order
  The user wants to finish an order

  @finish
  Scenario Outline: Finish an order
  	Given a cart with a <productName>
  	When user click on Place Order
  	And fill the form with <name>, <country>, <city>, <creditCard>, <month>, <year>
  	Then the order details must be shown with amount of 790
  	And user click on ok


    Examples: 
      | productCategory  | productName     | name  | country  | city  | creditCard | month  | year |
      | Laptops          | Sony vaio i5    | Fernando Torres | Spain | Valencia | 123456789 | 10 | 2022 |
