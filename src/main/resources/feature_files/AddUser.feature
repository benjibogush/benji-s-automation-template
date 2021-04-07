Feature: New users should be able to added  by the admin

  Background: Login to the environment
    Given the Admin admin is in login Page

  @AddUser
  Scenario: Admin can add new users
    Given admin navigates to recruitment page
    And click to add a "newUser"
    Then user logs off

  @AddUserNegative
  Scenario: Admin cannot add new users
