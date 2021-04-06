Feature: Admin User login to OrangeHRM system and add a new Employee to the system
Description: This is to verify login and add Employee functionalities of an Admin user

  @SmokeTest
Scenario Outline: Login to the system

Given the Admin <"admin"> is in login Page

Examples:
|user		|
|Admin      |
