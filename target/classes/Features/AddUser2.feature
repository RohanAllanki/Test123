@users
Feature: Adding the users to the List.
Background:
Given User is on reqres URL
@add
Scenario Outline: Add user
When User enters the "<name>" and "<job>"
And users hit the users API
Then Users are added to list

Examples:
|name|job|
|Narasimhulu|Software Eng|
|Rohan|Analyst|

@update
Scenario: Update the user
When User enters name & job
|ajay|software Engineer|
|karthik|amazon|
And user hits the users API
Then user data is updated