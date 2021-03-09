@regression
Feature: Administrator should see all products

  Background:
    Given I am landing on main page


  Scenario: As an administrator I want to see all the available products so that I can make fester decisions
    When I click List all Items button
    Then I should be able to see all available products


  Scenario: As an administrator I want to se detailed information about a specific product so that I know that the system is up to date.
    When I click List all Items button
    And I click open button of any product
    Then I should be able to see detailed information

  Scenario: As an administrator I want to be able to search for a specific product so that I can get faster access to its product details.
    Given I am landing on main page
    When I enter specific product information in the search box
    And I click find button
    Then I should be able to see detailed information of that product