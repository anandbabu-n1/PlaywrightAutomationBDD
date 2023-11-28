Feature: Verify your account

  @verifyaccount @smoke
  Scenario Outline: Verify User is able to enter confirmation code and verify the account
    Given user navigates to "url"
    When user clicks on "Verify Your Account" icon in main page
    And user gets the confirmation code on the screen
    And user enters the confirmation code
    Then user gets the success message
    
	Examples:
	|character |
	|Spider-Man|