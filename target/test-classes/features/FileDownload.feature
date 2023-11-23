Feature: Test the download file feature

  @filedownload @smoke
  Scenario Outline: Download the file
    Given user navigates to "url"
    When user clicks on "Download file" icon in main page
    Then user Downloads the file successfully
    
    
	Examples:
	|character |
	|Spider-Man|