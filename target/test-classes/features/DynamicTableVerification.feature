Feature: Find the text in dynamic table

  @smoke @dynamictable
  Scenario Outline: Find the Spider-Man in a table that changes the order of rows and assert his real name
    Given user navigates to "url"
    When user clicks on "Dynamic Table" icon in main page
    And user gets the name of "<character>"
    #And user enters "adminUsername" username
    #And user enters "adminPassword" password
    #And user clicks Login button
    #Then verify that user is logged in and navigated to Profile page
    
	Examples:
	|character |
	|Spider-Man|