Feature: validations inside iframe

  @iframe @smoke
  Scenario Outline: click the button inside the nested iframe
    Given user navigates to "url"
    When user clicks on "Sortable List" icon in main page
    Then User clicks the button inside the iframes
    
    
    
	Examples:
	|character |
	|Spider-Man|