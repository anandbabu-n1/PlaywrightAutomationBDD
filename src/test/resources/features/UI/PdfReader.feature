Feature: Read from Excel File

	@pdf
  Scenario: verify value in pdf
    Given user has "ToolsQA" file
    When user opens pdf
    Then user gets the text on the pdf