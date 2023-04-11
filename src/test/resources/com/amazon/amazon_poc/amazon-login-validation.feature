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
Feature: This feature file is to test the login functionality of amazon website with different credentials

  @login @positiveLogin
  Scenario Outline: verifying the login functionality with different credentials
    Given User on amazon home page
    When User click on sign in link from home page
    And User enter "<username>" and click continue button
    And User enter "<password>"

    #Please update with valid user name while evaluating the code run
    Examples: 
      | username | password |
      |          |          |

  @login @negativeLogin
  Scenario Outline: verifying the login functionality with different invalid credentials
    Given User on amazon home page
    When User click on sign in link from home page
    And User enter "<username>" and click continue button
    Then User verify the "<error heading>" and "<error>" message for "<scenario>" scenario

    Examples: 
      | username      | error heading          | error                                             | scenario            |
      | aasjelkklkd   | There was a problem    | We cannot find an account with that email address | invalidUsername     |
      |               |                        | Enter your email or mobile phone number           | blankUsername       |
      | 1237238728312 | Incorrect phone number | We cannot find an account with that mobile number | invalidMobileNumber |
