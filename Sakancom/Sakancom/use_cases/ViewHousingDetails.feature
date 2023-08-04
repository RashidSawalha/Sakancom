@Owner
  Feature: View Housing Details
    Scenario: view the number of the tenants and the number of floors for the selected housing unit
      Given the owner is on the dashboard
      When he selects elects one of their listed housing
      Then the number of tenants in the residence is displayed
      And the number of floors in the selected residence is shown

    Scenario: view the apartments of a selected floor from a housing unit
      When the owner select a specified floor number
      Then the he can view the apartments of that floor


    Scenario: view the tenants details and contact info of a selected apartment from a housing unit
      When choosing an apartment, the details of tenants and their contact information appear
      Then the number of bathrooms and bedrooms in the apartment is shown and the presence of a balcony in the apartment is indicated
