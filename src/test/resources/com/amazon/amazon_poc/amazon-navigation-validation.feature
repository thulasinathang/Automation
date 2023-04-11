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
Feature: This feature file is to test the navigation to different pages/module

  @navigation
  Scenario Outline: Navigating to different pages and modules
    Given User on amazon home page
    When User click on "<targetPage>"
    Then User validate the page title displayed as "<expectedTitle>"

    Examples: 
      | targetPage     | expectedTitle                                                                 |
      | createWishList | Wish List                                                                     |
      | amazonPay      | Amazon Pay                                                                    |
      | newRelease     | Amazon.in Hot New Releases: The bestselling new and future releases on Amazon |
