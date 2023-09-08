@RTB-58 @regression @ui @smoke
Feature: Search and Filter Products on Etsy with DataTable

  Scenario Outline: Validating Search for a product and apply filters
    Given user navigates to "EtsyApp" application
    When user searches for the "<Product>" product
    And user applies the following filters:
      | Special offers | <SpecialOffer> |
      | Price Range    | <PriceRange>   |
    Then the search results should display products "<Product>" within the price range "<PriceRange>"
    And the search results should display products with corresponding "<special offer>"
    Examples:
      | Product | PriceRange | SpecialOffer |
      | Carpet  | 50-500      | Free shipping |
      | Sofa    | 750-1500    | On Sale       |