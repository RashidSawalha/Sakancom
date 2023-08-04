@Admin
Feature: Modify
  Scenario: Modifying housing data
    Given Admin has logged in
    When the admin wants to modify a selected housing unit's data
    Then the admin can update the housing details And the modified data is saved in the system