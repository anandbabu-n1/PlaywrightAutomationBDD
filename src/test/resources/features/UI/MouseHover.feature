Feature: Verify text on popup

  @mousehover @smoke
  Scenario Outline: Open pop-up and click on the button in it and assert text on the main window
    Given user navigates to "url"
    When user clicks on "Mouse Hover" icon in main page
    And hovers the mouse pointer above the poster
    Then user gets the price of the poster
    
    
    
	Examples:
	|character |
	|Spider-Man|