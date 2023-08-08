@Admin
  Feature:Reservations
    Scenario: Watching reservations via the system
      Given the  administrator is logged in
      When there are reservations made for housing units
      Then the system administrator can view the reservations And the details of each reservation are displayed
