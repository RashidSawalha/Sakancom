@Admin
  Feature: Advertisements
    Scenario:Advertising housing units through the system
      Given Admin is logged in
      When the admin wants to add a new housing unit
      Then the housing unit is added to the system
      And it is ready to be advertised
