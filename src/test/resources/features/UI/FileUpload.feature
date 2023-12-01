Feature: Test the upload file feature

  @fileupload @smoke
  Scenario Outline: Upload a image file and verify the same
    Given user navigates to "url"
    When user clicks on "Upload file" icon in main page
    Then user uploads the "sample" image and assert the image name successfully
    
    
	Examples:
	|character |
	|Spider-Man|