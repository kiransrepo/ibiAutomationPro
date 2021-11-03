@Sanity
Feature: Login into Ibi

@Succes
  Scenario Outline: Login with valid username and password
    Given Launch the browser and enter the valid Prod URL
    When User redirects on landing page click on SignIn button
    Then Login page is displayed and enter the valid username and password "<scenario>" test scenario
    And click on Continue button
    Then User lands on inner circle page

Examples:
|scenario|
|Success|
    
@Failure
  Scenario Outline: Login with invalid username and valid password
    Given Launch the browser and enter the valid Prod URL
    When User redirects on landing page click on SignIn button
    Then Login page is displayed and enter the invalid username and valid password based on "<scenario>" test scenario
    And click on Continue button
    Then User will be unable to login and error message is displayed
    
Examples:
|scenario|
|Failure|

@Succ
Scenario: Verify forgot link 
    Given Launch the browser and enter the valid Prod URL
    When User redirects on landing page click on SignIn button
    Then Login page is displayed and verify forgot link is visiable
    And Click on forgot link
    Then Verify user lands on rest password page