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
@restapi
Feature: Title of your feature
  I want to use this template for my feature file

  @tag1
  Scenario Outline: Test Scenario for GET https://jsonplaceholder.typicode.com/todos/1
    Given set base uri of application '<baseURI>'
    When perform get operation for '<serviceURI>'
    Then verify response code '<code>'
    Then verify response body contains:
      | userId | 1 |

    Examples: 
      | baseURI                               | serviceURI | code |
      | https://jsonplaceholder.typicode.com/ | /todos/1   |  200 |

  @tag2
  Scenario Outline: Test Scenario for GET https://reqres.in/api/users?page=2
    Given set base uri of application '<baseURI>'
    When perform get operation for '<serviceURI>' along with query paramters:
      | page | 2 |
    Then verify response code '<code>'
    Then verify response body contains:
      | data.email[0] | michael.lawson@reqres.in |

    Examples: 
      | baseURI            | serviceURI | code |
      | https://reqres.in/ | /api/users |  200 |
      
      @tag3
  Scenario Outline: Test Scenario for POST https://reqres.in/api/login
    Given set base uri of application '<baseURI>'
    When perform post operation for '<serviceURI>' with payload as '<requestPayLoad>'
    Then verify response code '<code>'
    Then verify response body contains:
      | token | QpwL5tke4Pnpja7X4 |

    Examples: 
      | baseURI            | serviceURI | code |requestPayLoad|
      | https://reqres.in/ | /api/login |  200 |login.json|
      
