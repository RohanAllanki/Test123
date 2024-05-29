@tag
Feature: Adding user with Excel File
@tag1
Scenario: Add user
Given User is on reqres website
When User enters the data from the excel sheet
And User hits the users API
Then Users are added to the List

