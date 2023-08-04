@Owner
  Feature: Announcing residences
    Scenario: Announcing private residences with options
      Given the owner is on the dashboard control panel
#      (logged in )
      When the owner provides location and description about the residence
      And specifies the available services
      And sets the monthly rent, indicating whether it includes electricity and water
      And provide contact information for potential tenants
      Then the owner can announce the residence