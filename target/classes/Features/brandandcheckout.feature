
Feature: search an item from brand and do the checkout
  Scenario: select an item and checkout
    Given user is at brandhome page
    And user click on menu button
    And user click on brand button
    And user click on product button
    And user click on particular item button
    When user click on brandadd to cart button  
    Then user click on brandgo to cart button
    When user click on checkout button 
    And user click on continue as a guest 
    And user enters first name 
    And user enters last name 
    And user enters street name
    And user enters city name
    And user select  state name
    And user enters  zip code
    And user enters  zip code
    When user select  billing address checkbox
    Then user click on apply button