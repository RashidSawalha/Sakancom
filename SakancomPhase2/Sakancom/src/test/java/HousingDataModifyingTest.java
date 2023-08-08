import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class HousingDataModifyingTest {

    static Admin admin=new Admin();

    Owners owner1 =new Owners("Ahmed");
    Owners owner2 =new Owners("Ali");
    Owners owner3 =new Owners("Khaled");

    Tenants tenant1=new Tenants("Alaa",1);
    Tenants tenant2=new Tenants("Abdullah",2);
    Tenants tenant3=new Tenants("Sami",3);


    Housing housing1=new Housing("Asira Hotel1","g","",100,true,1,owner1.getName());
    Housing housing2=new Housing("Asira Hotel2","gg","",200,true,2,owner2.getName());
    Housing housing3=new Housing("Asira Hotel3","ggg","",300,true,3,owner3.getName());

    Request req1=new Request(1,housing1);
    Request req2=new Request(2,housing2);
    Request req3=new Request(3,housing3);

    String  expected , actualRes;

    @Given("Admin has logged in")
    public void admin_has_logged_in() {
        admin.login("Rashed","rashed123");
        assertTrue(admin.getLoggedIN());
    }
    @When("the admin wants to modify a selected housing unit's data")
    public void the_admin_wants_to_modify_a_selected_housing_unit_s_data() {
        admin.addRequest(req1);
        admin.addRequest(req2);
        admin.addRequest(req3);

        admin.acceptAdvertisementRequest(req1.getRequestId());
        admin.acceptAdvertisementRequest(req2.getRequestId());
        admin.acceptAdvertisementRequest(req3.getRequestId());

        admin.addHousing(req1.getHousing());
        admin.addHousing(req2.getHousing());
        admin.addHousing(req3.getHousing());
    }
    @Then("the admin can update the housing details And the modified data is saved in the system")
    public void the_admin_can_update_the_housing_details_and_the_modified_data_is_saved_in_the_system() {
        actualRes= admin.modifyHousingData(1,"welcome","pp",500,false);
        expected = "welcome";
        assertEquals(actualRes,expected);
    }


}
