
Feature: check user registration functionalites
 
  Scenario: user registration
    Given user is at sitehome page
    When user click create account button
    And user send first name
    And user send last name
    And user send email
    And user send password
    And user send confirm password
    And user send mobile number
    When user click on recovery button
    Then click on submit button

 
