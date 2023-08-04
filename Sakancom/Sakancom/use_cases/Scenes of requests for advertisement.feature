@Admin
Feature: Accepting and rejecting requests for housing advertisement
  Scenario: Accepting the request
    Given the  admin is logged in
    When there is a request for housing advertisement
    Then the admin can view the request details
    And the admin chooses to accept the request
    And the status of the request is updated accordingly

  Scenario: Rejecting the request
    Given The admin is logged in
    When There is a request for housing advertisement
    Then the system administrator can view the request details
    And the system administrator can chooses to reject the request
    And The status of the request is updated accordingly