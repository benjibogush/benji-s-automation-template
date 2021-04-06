Feature: Users can reset their passwords

  Background: Login to the environment
    Given the Admin <"admin"> is in login Page
      |user		|
      |Admin    |



    @Positive
    Scenario: User can enter letters and digits for password
              Given user can navigate to password reset module

    @Negative
    Scenario: password reset button is not functional
