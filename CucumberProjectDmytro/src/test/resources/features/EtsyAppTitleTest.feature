@regression @smoke @ui @RTB-13
Feature: Validating Etsy titles

  Scenario Outline: Validating Etsy categories titles
    Given user navigates to "EtsyApp" application
    When user clicks on specific "<category>" category
    Then user validates the title is "<title>"
    Examples:
      | category              | title                        |
      | Labor Day Sales Event | Etsy Labor Day Sales Event   |
      | Jewelry & Accessories | Jewelry & Accessories - Etsy |

