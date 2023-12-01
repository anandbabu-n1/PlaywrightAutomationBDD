Feature: Manipulation with Tags

  @TagsInputBox @smoke
  Scenario Outline: Add and remove tags and assert tag's presence and count
    Given user navigates to "url"
    When user clicks on "Tags Input Box" icon in main page
    And user gets the number of tags needed
    And user enters the number of tags needed
    Then user verifies no tags are needed
    
	Examples:
	|character |
	|Spider-Man|