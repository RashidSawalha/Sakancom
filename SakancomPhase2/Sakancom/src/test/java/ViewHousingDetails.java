import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ViewHousingDetails {

    Owners owner = new Owners("Ahmad");

    Tenants tenant1=new Tenants("Alia","alia@gg.com","0599887766",1);
    Tenants tenant2=new Tenants("Sami","sami@gg.com","0598765532",2);
    Tenants tenant3=new Tenants("Saeed","saeed@gg.com","0599123365",3);
    Tenants tenant4=new Tenants("Musa","musa@gg.com","0577846632",4);
    Tenants tenant5=new Tenants("Gavi","gavi@gg.com","1234567890",5);
    Tenants tenant6=new Tenants("Pedri","pedri@gg.com","0987654321",6);

    Housing housing1=new Housing("Asira Hotel1","g","",100,true,1,owner.getName());
    Housing housing2=new Housing("Asira Hotel2","gg","",200,true,2,owner.getName());

    Apartments apartment1 = new Apartments(1,1,2,3,true);
    Apartments apartment2 = new Apartments(1,2,2,2,true);
    Apartments apartment3 = new Apartments(2,3,2,3,true);
    Apartments apartment4 = new Apartments(2,4,2,2,true);
    Apartments apartment5 = new Apartments(3,5,2,3,true);
    Apartments apartment6 = new Apartments(2,6,2,2,true);
    Apartments apartment7 = new Apartments(4,7,3,4,false);
    Apartments apartment8 = new Apartments(4,8,3,3,false);


    @Given("the owner is on the dashboard")
    public void the_owner_is_on_the_dashboard() {
        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());
        owner.addHousing(housing1);
        housing1.addApartment(apartment1);
        housing1.addApartment(apartment3);
        housing1.addApartment(apartment5);
        housing1.addApartment(apartment7);
        housing1.addApartment(apartment8);

        owner.addHousing(housing2);
        housing2.addApartment(apartment2);
        apartment2.addTenant(tenant1);
        apartment2.addTenant(tenant2);
        apartment2.addTenant(tenant3);

        housing2.addApartment(apartment4);
        apartment2.addTenant(tenant4);
        apartment2.addTenant(tenant5);

        housing2.addApartment(apartment6);
        apartment2.addTenant(tenant6);
    }
    @When("he selects elects one of their listed housing")
    public void he_selects_elects_one_of_their_listed_housing() {
        owner.getHousingUnit(housing2.getHousingId());
    }
    @Then("the number of tenants in the residence is displayed")
    public void the_number_of_tenants_in_the_residence_is_displayed() {
        int expected =6;
        int res = owner.getHousingUnit(housing2.getHousingId()).getNumberOfTenants();
        System.out.println(res);
        assertEquals(res,expected);
    }
    @Then("the number of floors in the selected residence is shown")
    public void the_number_of_floors_in_the_selected_residence_is_shown() {
        int expected =2;
        int res = owner.getHousingUnit(housing2.getHousingId()).getNumberOfFloors();
        assertEquals(res,expected);
    }


    ///////////////////////////////////////////////////////////////////////////////

    @When("the owner select a specified floor number")
    public void the_owner_select_a_specified_floor_number() {
        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());
        owner.addHousing(housing1);
        housing1.addApartment(apartment1);
        housing1.addApartment(apartment3);
        housing1.addApartment(apartment5);
        housing1.addApartment(apartment7);
        housing1.addApartment(apartment8);

        owner.addHousing(housing2);
        housing2.addApartment(apartment2);
        apartment2.addTenant(tenant1);
        apartment2.addTenant(tenant2);
        apartment2.addTenant(tenant3);

        housing2.addApartment(apartment4);
        apartment2.addTenant(tenant4);
        apartment2.addTenant(tenant5);

        housing2.addApartment(apartment6);
        apartment2.addTenant(tenant6);
        owner.getHousingUnit(housing2.getHousingId()).getApartments(2);
    }
    @Then("the he can view the apartments of that floor")
    public void the_he_can_view_the_apartments_of_that_floor() {
        ArrayList<Apartments>expected = new ArrayList<>();
        expected.add(apartment4);
        expected.add(apartment6);
        ArrayList<Apartments>actual=owner.getHousingUnit(housing2.getHousingId()).getApartments(2);
        assertEquals(expected,actual);
    }

    /////////////////////////////////////////////////////////////////////////////

    @When("choosing an apartment, the details of tenants and their contact information appear")
    public void choosing_an_apartment_the_details_of_tenants_and_their_contact_information_appear() {
        owner.login("Ahmad","ahmad123");
        assertTrue(owner.getLoggedIN());
        owner.addHousing(housing1);
        housing1.addApartment(apartment1);
        housing1.addApartment(apartment3);
        housing1.addApartment(apartment5);
        housing1.addApartment(apartment7);
        housing1.addApartment(apartment8);

        owner.addHousing(housing2);
        housing2.addApartment(apartment2);
        apartment2.addTenant(tenant1);
        apartment2.addTenant(tenant2);
        apartment2.addTenant(tenant3);

        housing2.addApartment(apartment4);
        apartment4.addTenant(tenant4);
        apartment4.addTenant(tenant5);

        housing2.addApartment(apartment6);
        apartment6.addTenant(tenant6);

        owner.getHousingUnit(housing2.getHousingId()).getApartment(apartment6.getApartmentID()).viewTenantsDetails();
    }
    @Then("the number of bathrooms and bedrooms in the apartment is shown and the presence of a balcony in the apartment is indicated")
    public void the_number_of_bathrooms_and_bedrooms_in_the_apartment_is_shown_and_the_presence_of_a_balcony_in_the_apartment_is_indicated() {
        int actual1  =owner.getHousingUnit(housing2.getHousingId()).getApartment(apartment6.getApartmentID()).getBathrooms();
        int expected1 =2;
        assertEquals(actual1,expected1);
        int expected2=2;
        int actual2 =owner.getHousingUnit(housing2.getHousingId()).getApartment(apartment6.getApartmentID()).getBedrooms();
        assertEquals(actual2,expected2);
        assertTrue(owner.getHousingUnit(housing2.getHousingId()).getApartment(apartment6.getApartmentID()).hasBalcony());
    }
}
