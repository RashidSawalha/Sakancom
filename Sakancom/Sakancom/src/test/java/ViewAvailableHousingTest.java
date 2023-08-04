import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class ViewAvailableHousingTest {

    Admin admin=new Admin();

    Owners owner = new Owners("Ahmad","ahmad@gmail.com","0255876632");

    Tenants tenant1=new Tenants("Alia","alia@gg.com","0599887766",1);
    Tenants tenant2=new Tenants("Pedri","pedri@gg.com","0987654321",2);
    Tenants tenant3=new Tenants("Saeed","saeed@gg.com","0599123365",3);
    Tenants tenant4=new Tenants("Musa","musa@gg.com","0577846632",4);
    Tenants tenant5=new Tenants("Gavi","gavi@gg.com","1234567890",5);
    Tenants tenant6=new Tenants("Sami","sami@gg.com","0598765532",6);

    Housing housing1=new Housing("Asira ","Asira Hotel1","GYM / Parking",100,true,1,owner);
    Housing housing2=new Housing("Asira ","Asira Hotel2","Pool / Club",200,true,2,owner);

    Apartments apartment1 = new Apartments(1,1,2,3,true);
    Apartments apartment2 = new Apartments(2,2,2,3,false);
    Apartments apartment3 = new Apartments(2,3,2,2,false);
    Apartments apartment4 = new Apartments(3,4,2,3,true);
    Apartments apartment5 = new Apartments(3,5,2,3,true);
    Apartments apartment6 = new Apartments(2,6,2,2,true);
    Apartments apartment7 = new Apartments(4,7,3,4,false);
    Apartments apartment8 = new Apartments(4,8,3,3,false);


    @When("the tenant is on the housing platform")
    public void the_tenant_is_on_the_housing_platform() {

        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());

        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());

        owner.addHousing(housing1);
        housing1.setAdvertised(true);
        housing1.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        housing1.addApartment(apartment2);
        apartment2.addTenant(tenant2);
        housing1.addApartment(apartment3);
        apartment3.addTenant(tenant3);
        housing1.addApartment(apartment4);
        apartment4.addTenant(tenant4);
        apartment4.addTenant(tenant5);

        owner.addHousing(housing2);
        housing2.setAdvertised(true);
        housing2.addApartment(apartment5);
        housing2.addApartment(apartment6);
        housing2.addApartment(apartment7);
        housing2.addApartment(apartment8);

        tenant6.login("Sami","sami123");
        assertTrue(tenant6.getLoggedIN());

        admin.addHousing(housing1);
        admin.addHousing(housing2);
    }
    @Then("they view the list of available housing")
    public void they_view_the_list_of_available_housing() {
        tenant6.viewAvailableHousingUnits(admin);
    }


    ///////////////////////////////////////////////////////////////////////

    @When("The tenant is logged in and chooses a specified housing unit")
    public void the_tenant_is_logged_in_and_chooses_a_specified_housing_unit() {
        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());

        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());

        owner.addHousing(housing1);
        housing1.setAdvertised(true);
        housing1.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        housing1.addApartment(apartment2);
        apartment2.addTenant(tenant2);
        housing1.addApartment(apartment3);
        apartment3.addTenant(tenant3);
        housing1.addApartment(apartment4);
        apartment4.addTenant(tenant4);
        apartment4.addTenant(tenant5);

        owner.addHousing(housing2);
        housing2.setAdvertised(true);
        housing2.addApartment(apartment5);
        housing2.addApartment(apartment6);
        housing2.addApartment(apartment7);
        housing2.addApartment(apartment8);

        tenant6.login("Sami","sami123");
        assertTrue(tenant6.getLoggedIN());

        admin.addHousing(housing1);
        admin.addHousing(housing2);
    }
    @Then("they should be able to see the options for housing")
    public void they_should_be_able_to_see_the_options_for_housing() {
        tenant6.viewSelectedHousingDetails(housing1.getHousingId(),admin);
    }
    ///////////////////////////////////////////////////////////////////////////

    @Given("the tenant is logged in onto the housing platform")
    public void the_tenant_is_logged_in_onto_the_housing_platform() {

        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());

        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());

        owner.addHousing(housing1);
        housing1.setAdvertised(true);
        housing1.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        housing1.addApartment(apartment2);
        apartment2.addTenant(tenant2);
        housing1.addApartment(apartment3);
        apartment3.addTenant(tenant3);
        housing1.addApartment(apartment4);
        apartment4.addTenant(tenant4);
        apartment4.addTenant(tenant5);

        owner.addHousing(housing2);
        housing2.setAdvertised(true);
        housing2.addApartment(apartment5);
        housing2.addApartment(apartment6);
        housing2.addApartment(apartment7);
        housing2.addApartment(apartment8);

        tenant6.login("Sami","sami123");
        assertTrue(tenant6.getLoggedIN());

        admin.addHousing(housing1);
        admin.addHousing(housing2);

        tenant6.viewAvailableHousingUnits(admin);

        tenant6.viewSelectedHousingDetails(housing1.getHousingId(),admin);
    }
    @When("they book accommodation through the app")
    public void they_book_accommodation_through_the_app() {
        tenant6.bookAccommodation(admin,housing1,apartment1);
    }
    @Then("they should receive a confirmation of their booking")
    public void they_should_receive_a_confirmation_of_their_booking() {
        tenant6.viewSelectedHousingDetails(housing1.getHousingId(),admin);
    }

    ////////////////////////////////////////////////////////////////////////

    @When("the tenant has booked accommodation and access their tenant control panel")
    public void the_tenant_has_booked_accommodation_and_access_their_tenant_control_panel() {
        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());

        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());

        owner.addHousing(housing1);
        housing1.setAdvertised(true);
        housing1.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        housing1.addApartment(apartment2);
        apartment2.addTenant(tenant2);
        housing1.addApartment(apartment3);
        apartment3.addTenant(tenant3);
        housing1.addApartment(apartment4);
        apartment4.addTenant(tenant4);
        apartment4.addTenant(tenant5);

        owner.addHousing(housing2);
        housing2.setAdvertised(true);
        housing2.addApartment(apartment5);
        housing2.addApartment(apartment6);
        housing2.addApartment(apartment7);
        housing2.addApartment(apartment8);

        tenant6.login("Sami","sami123");
        assertTrue(tenant6.getLoggedIN());

        admin.addHousing(housing1);
        admin.addHousing(housing2);

        tenant6.viewAvailableHousingUnits(admin);

        tenant6.viewSelectedHousingDetails(housing1.getHousingId(),admin);

        tenant6.bookAccommodation(admin,housing1,apartment1);
    }
    @Then("they should see their personal data and information about the residence owner and they should see information about rent payment timing")
    public void they_should_see_their_personal_data_and_information_about_the_residence_owner_and_they_should_see_information_about_rent_payment_timing() {
        tenant6.TenantControlPanel(admin,housing1,apartment1);
    }

}
