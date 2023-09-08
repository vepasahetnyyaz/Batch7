@regression @ui @smoke
Feature: Pizza application place order functionality

  @RTB-99
  Scenario Outline: Validating successful place order
    Given user navigates to "MindtekPizzaApp" application
    When user creates pizza order
      | Pizza    | <Pizza>    |
      | Topping1 | <Topping1> |
      | Topping2 | <Topping2> |
      | Quantity | <Quantity> |
      | Name     | <Name>     |
      | Email    | <Email>    |
      | Phone    | <Phone>    |
      | Payment  | <Payment>  |
    Then user validates that order is creates with message "Thank you for your order! TOTAL: " "<Quantity>" "<Pizza>"
    Examples:
      | Pizza                        | Topping1  | Topping2     | Quantity | Name        | Email           | Phone      | Payment        |
      | Small 6 Slices - no toppings | Mushrooms | Extra cheese | 1        | Patel Harsh | patel@gmail.com | 123456789  | Cash on Pickup |
      | Medium 8 Slices - 2 toppings | Salami    | Olives       | 2        | John Doe    | john@gmail.com  | 9876543112 | Credit Card    |