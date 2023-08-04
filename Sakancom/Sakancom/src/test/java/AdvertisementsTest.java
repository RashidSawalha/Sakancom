import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class AdvertisementsTest {

    Admin admin=new Admin();

    Owners owner1 =new Owners("Ahmed");
    Owners owner2 =new Owners("Ali");
    Owners owner3 =new Owners("Khaled");

    Tenants tenant1=new Tenants("Alia",1);
    Tenants tenant2=new Tenants("Abdullah",2);
    Tenants tenant3=new Tenants("Sami",3);


    Housing housing1=new Housing("Asira Hotel1","g","",100,true,1,owner1.getName());
    Housing housing2=new Housing("Asira Hotel2","gg","",200,true,2,owner2.getName());
    Housing housing3=new Housing("Asira Hotel3","ggg","",300,true,3,owner3.getName());

    Request req1=new Request(1,housing1);
    Request req2=new Request(2,housing2);
    Request req3=new Request(3,housing3);

    Reservations reservation1 = new Reservations(tenant1,housing1.getHousingId());
    Reservations reservation2 = new Reservations(tenant2,housing2.getHousingId());
    Reservations reservation3 = new Reservations(tenant3,housing3.getHousingId());

    @Given("Admin is logged in")
    public void admin_is_logged_in() {
        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());
    }
    @When("the admin wants to add a new housing unit")
    public void the_admin_wants_to_add_a_new_housing_unit() {
        admin.addRequest(req1);
        admin.addRequest(req2);
        admin.addRequest(req3);

        admin.acceptAdvertisementRequest(req1.getRequestId());
        admin.acceptAdvertisementRequest(req2.getRequestId());
        admin.acceptAdvertisementRequest(req3.getRequestId());

    }
    @Then("the housing unit is added to the system")
    public void the_housing_unit_is_added_to_the_system() {
        admin.addHousing(req1.getHousing());
        admin.addHousing(req2.getHousing());
        admin.addHousing(req3.getHousing());
    }
    @Then("it is ready to be advertised")
    public void it_is_ready_to_be_advertised() {
        assertTrue(admin.advertiseHousingUnit(req1.getHousing().getHousingId()) && admin.advertiseHousingUnit(req2.getHousing().getHousingId()) && admin.advertiseHousingUnit(req3.getHousing().getHousingId()));
    }

}
