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
@amazonTest
Feature: This feature file is to test url and title validation for amazon poc project

  @urlValidation @titleValidation
  Scenario Outline: URL and page title validation
    When User enter the url as "<url>"
    Then User validate that URL is redirected to "<expectedUrl>"
    And User validate the page title displayed as "<expectedTitle>"

    Examples: 
      | url            | expectedUrl            | expectedTitle                                                                                      |
      | http://amzn.in | https://www.amazon.in/ | Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in |
