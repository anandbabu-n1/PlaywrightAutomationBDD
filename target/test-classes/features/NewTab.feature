Feature: Verify your account

  @newtab @smoke
  Scenario Outline: Enter valid code by pressing the key-up button or typing number and assert success message
    Given user navigates to "url"
    When user clicks on "New Tab" icon in main page
    And user clicks on the New Tab button
    And user verify the text on the new web page
    
    
	Examples:
	|character |
	|Spider-Man|