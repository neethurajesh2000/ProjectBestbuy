
Feature: search an item and add  to cart
  Scenario: search to cart
    Given user ia at searchhome page 
    And user search the product
    When user search refrigerator white
    And user click on add to cart button   
    Then user click on go to cart button
  

 