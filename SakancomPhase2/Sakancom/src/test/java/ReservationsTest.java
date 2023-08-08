import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReservationsTest {

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

    @Given("the  administrator is logged in")
    public void the_administrator_is_logged_in() {
        admin.login("Alaa","alaa123");
        assertTrue(admin.getLoggedIN());

        admin.addRequest(req1);
        admin.addRequest(req2);
        admin.addRequest(req3);


        admin.viewRequestDetails(req1);
        admin.viewRequestDetails(req2);
        admin.viewRequestDetails(req3);

        admin.acceptAdvertisementRequest(req1.getRequestId());
        admin.acceptAdvertisementRequest(req2.getRequestId());
        admin.acceptAdvertisementRequest(req3.getRequestId());


    }
    @Test
    @When("there are reservations made for housing units")
    public void there_are_reservations_made_for_housing_units() {
        admin.addReservation(reservation1);
        admin.addReservation(reservation2);
        admin.addReservation(reservation3);
    }
    @Then("the system administrator can view the reservations And the details of each reservation are displayed")
    public void the_system_administrator_can_view_the_reservations_and_the_details_of_each_reservation_are_displayed() {
        assertTrue(admin.viewReservations());
    }

}
