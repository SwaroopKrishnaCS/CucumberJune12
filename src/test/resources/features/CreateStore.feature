#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

  @createStore
  Scenario: Validate storeId is generated when posted a request to create a store
    Given the api is available
    And the request body is created
      | name           | type        | address             | city     | state   | zip    |
      | BestBuy Mobile | MobileStore | Bramlea City Centre | Brampton | Ontario | L6C1C1 |
    When the api is invoked using Post Method
    Then the response should come with a status code of 201
    And the response body should have a value in the store id field
