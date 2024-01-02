Feature: Manipulation with Tags

  @QRcode @smoke
  Scenario Outline: Add and remove tags and assert tag's presence and count
    Given user navigates to "url"
    When user clicks on "QR code generator" icon in main page
    And user enters the "<character>" on the text field
    Then user downloads the QR code "<character>"
    Then user validates the QR code for the text "<character>"
    
	Examples:
	|character |
	|testname|