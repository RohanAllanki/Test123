Feature: Adding the users to the List.

Scenario Outline: Add user
Given User is on reqres URL
When User enters the "<name>" and "<job>"
And users hit the users API
Then Users are added to list

Examples:
|name|job|
|Narasimhulu|Software Eng|
|Rohan|Analyst|

Scenario: Update the user
Given User is on reqres URL
When User enters name & job
|ajay|software Engineer|
|karthik|amazon|
And user hits the users API
Then user data is updated