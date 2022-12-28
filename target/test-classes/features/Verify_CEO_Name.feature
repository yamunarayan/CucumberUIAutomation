@GetCEOName
Feature: This feature is to get the CEO name from OrangeHRM app

  Scenario Outline: This test is to verify the CEO name
    Given User logged in successfully
    When User clicks on the directory option from the menu bar
    And The user selects the job title as "Chief Executive Officer" from the dropdown "text"
    And Clicks the search button
    Then The user should see the CEO name as "<CEO_Name>"

    Examples:
    |CEO_Name|
    |John Smith|