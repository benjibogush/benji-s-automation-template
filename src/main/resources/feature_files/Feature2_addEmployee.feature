Feature: Add single of multiple employees to the system



Scenario Outline: Add Single New Employee

  Given the Admin user is in login Page
  Then he enters "<admin>" credentials
  Then click the login button

Given the "<user>" is in Add Employee Page
When he enters "<employee>" information
And submits form
Then that Employee is shown in the list

Examples:
|user |employee|
|Admin|Yashika2|
