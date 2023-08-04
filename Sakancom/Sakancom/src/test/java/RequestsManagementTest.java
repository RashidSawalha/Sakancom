import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.BeforeClass;

import static org.junit.Assert.*;

public class RequestsManagementTest {

        static Admin admin = new Admin();

        Owners owner1 =new Owners("Ahmed");
        Owners owner2 =new Owners("Ali");
        Owners owner3 =new Owners("Khaled");



        Housing housing1=new Housing("Asira Hotel1","g","",100,true,1,owner1.getName());
        Housing housing2=new Housing("Asira Hotel2","gg","",200,true,2,owner2.getName());
        Housing housing3=new Housing("Asira Hotel3","ggg","",300,true,3,owner3.getName());
        Housing housing4=new Housing("Asira Hotel4","gggg","",400,true,4,owner2.getName());
        Housing housing5=new Housing("Asira Hotel5","ggggg","",500,true,5,owner3.getName());

        Request req1=new Request(1,housing1);
        Request req2=new Request(2,housing2);
        Request req3=new Request(3,housing3);
        Request req4=new Request(4,housing4);
        Request req5=new Request(5,housing5);


    @Given("the  admin is logged in")
    public void the_admin_is_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        admin.login("Alaa","alaa123");
        assertTrue(admin.getLoggedIN());
    }
    @When("there is a request for housing advertisement")
    public void there_is_a_request_for_housing_advertisement() {
        admin.addRequest(req1);
        admin.addRequest(req2);
        admin.addRequest(req3);

    }
    @Then("the admin can view the request details")
    public void the_admin_can_view_the_request_details() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertTrue(admin.viewRequestDetails(req1));
        assertTrue(admin.viewRequestDetails(req2));
        assertTrue(admin.viewRequestDetails(req3));
    }
    @Then("the admin chooses to accept the request")
    public void the_admin_chooses_to_accept_the_request() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertTrue(admin.acceptAdvertisementRequest(req1.getRequestId()));
        assertTrue(admin.acceptAdvertisementRequest(req2.getRequestId()));
        assertTrue(admin.acceptAdvertisementRequest(req3.getRequestId()));

    }
    @Then("the status of the request is updated accordingly")
    public void the_status_of_the_request_is_updated_accordingly() {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        System.out.println("");
        assertTrue(admin.viewRequestDetails(req1));
        assertTrue(admin.viewRequestDetails(req2));
        assertTrue(admin.viewRequestDetails(req3));
    }

    //////////////////////////////////////////////////////////////////////

    @Given("The admin is logged in")
    public void The_admin_is_logged_in() {
        System.out.println("");
        System.out.println("");
        System.out.println("");


        assertTrue(admin.getLoggedIN());
    }
    @When("There is a request for housing advertisement")
    public void There_is_a_request_for_housing_advertisement() {
        admin.addRequest(req4);
        admin.addRequest(req5);
    }
    @Then("the system administrator can view the request details")
    public void the_system_administrator_can_view_the_request_details() {
        assertTrue(admin.viewRequestDetails(req4));
        assertTrue(admin.viewRequestDetails(req5));
    }
    @Then("the system administrator can chooses to reject the request")
    public void the_system_administrator_can_chooses_to_reject_the_request() {
        assertTrue(admin.rejectAdvertisementRequest(req4.getRequestId()));
        assertTrue(admin.rejectAdvertisementRequest(req5.getRequestId()));
    }
    @Then("The status of the request is updated accordingly")
    public void The_status_of_the_request_is_updated_accordingly() {
        System.out.println("");
        assertTrue(admin.viewRequestDetails(req4));
        assertTrue(admin.viewRequestDetails(req5));
    }



}
