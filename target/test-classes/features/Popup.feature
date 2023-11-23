Feature: Verify text on popup

  @popup @smoke
  Scenario Outline: Open pop-up and click on the button in it and assert text on the main window
    Given user navigates to "url"
    When user clicks on "Pop-Up Window" icon in main page
    And user clicks on the open button
    And user clicks button on the popup
    Then user verifies the text on the main page
    
    
	Examples:
	|character |
	|Spider-Man|