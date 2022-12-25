Feature: This feature is to get pending timesheet

  Scenario Outline: This is to verify the pending timesheet
    Given User is on the home page
    And User clicks on the time option from menu
    And User enters name as "John Smith"
    And Clicks on the view button
    Then User should see the message as "<message>"

    Examples:
    |message|
    |No Timesheets Found|