@Login
Feature: login

  Scenario: Admin Login
    Given the system administrator is on the login page
    When the system administrator enters valid credentials
    Then the system administrator is logged in
    And the dashboard is displayed

  Scenario: Owner Login
    Given The owner is on the login page
    When The owner enters valid credentials
    Then The owner is logged in
    And The owner dashboard is displayed


  Scenario: Tenant Login
    Given The tenant is on the login page
    When The tenant enters valid credentials
    Then The tenant is logged in
    And The tenant dashboard is displayed