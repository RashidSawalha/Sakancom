@Tenant
  Feature: The ability to view the available housing
    Scenario: View Available Housing
      When the tenant is on the housing platform
      Then they view the list of available housing

      Scenario: The ability to view housing Details such as owner name, the prices, location, and
      services available in them
        When The tenant is logged in and chooses a specified housing unit
        Then they should be able to see the options for housing

    Scenario: Book Accommodation
      Given the tenant is logged in onto the housing platform
      When they book accommodation through the app
      Then they should receive a confirmation of their booking

    Scenario: View Tenant Control Panel
      When the tenant has booked accommodation and access their tenant control panel
      Then they should see their personal data and information about the residence owner and they should see information about rent payment timing
