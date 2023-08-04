import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class AnnouncingTest {
    Owners owner =new Owners("Ahmad");

    Tenants tenant1=new Tenants("Alia",1);
    Tenants tenant2=new Tenants("Sami",2);
    Tenants tenant3=new Tenants("Saeed",3);
    Tenants tenant4=new Tenants("Musa",4);
    Tenants tenant5=new Tenants("Gavi",5);
    Tenants tenant6=new Tenants("Pedri",6);

    Housing housingUnit = new Housing(owner,1);

    Apartments apartment1 = new Apartments(1,1,2,3,false);
    Apartments apartment2 = new Apartments(2,2,1,2,true);

    Request req ;

    @Given("the owner is on the dashboard control panel")
    public void the_owner_is_on_the_dashboard_control_panel() {
        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());
    }
    @When("the owner provides location and description about the residence")
    public void the_owner_provides_location_and_description_about_the_residence() {
        housingUnit.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        apartment1.addTenant(tenant2);
        apartment1.addTenant(tenant3);
        housingUnit.addApartment(apartment2);
        apartment2.addTenant(tenant5);
        apartment2.addTenant(tenant6);

        owner.addHousing(housingUnit);

        owner.getHousingUnit(housingUnit.getHousingId()).setName("nice housing unit with two floors and a two different apartments");
        owner.getHousingUnit(housingUnit.getHousingId()).setLocation("Nablus-Asira ST");

    }
    @When("specifies the available services")
    public void specifies_the_available_services() {
        owner.getHousingUnit(housingUnit.getHousingId()).setServices("free WiFi ,parking space ,pool");
    }
    @When("sets the monthly rent, indicating whether it includes electricity and water")
    public void sets_the_monthly_rent_indicating_whether_it_includes_electricity_and_water() {
        owner.getHousingUnit(housingUnit.getHousingId()).setIncludesElectricityWater(true);
        owner.getHousingUnit(housingUnit.getHousingId()).setMonthlyRent(500);
    }
    @When("provide contact information for potential tenants")
    public void provide_contact_information_for_potential_tenants() {
        owner.setEmail("ahmad99@gmail.com");
        owner.setPhoneNumber("05992232221");
    }
    @Then("the owner can announce the residence")
    public void the_owner_can_announce_the_residence() {
        req=new Request(1,housingUnit );
        assertEquals(req.getStatus(),"Pending");
    }
}
