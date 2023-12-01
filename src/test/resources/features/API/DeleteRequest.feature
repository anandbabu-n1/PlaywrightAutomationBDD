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
#@tag
Feature: Delete Request

  @api6 @apitest
  Scenario Outline: To verify the Delete request call to an endpoint
    
    When I send the Delete call on the "<endpoint>" with "<name>" and "<job>" as data
    Then I get the response status as success with response code "<code>"
    
    Examples: 
      | endpoint  | name | job | code |
      | /api/users/2 | test | Lead | 204|
