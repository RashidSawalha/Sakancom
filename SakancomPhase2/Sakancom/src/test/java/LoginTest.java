import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

public class LoginTest {

    Admin admin=new Admin();
    Owners owner =new Owners();
    Tenants tenant =new Tenants();

    @Given("the system administrator is on the login page")
    public void the_system_administrator_is_on_the_login_page() {
        assertFalse(admin.getLoggedIN());

    }

    @When("the system administrator enters valid credentials")
    public void the_system_administrator_enters_valid_credentials() {
        admin.login("Alaa","alaa123");
    }


    @Then("the system administrator is logged in")
    public void the_system_administrator_is_logged_in() {
        assertTrue(admin.getLoggedIN());
    }

    @Then("the dashboard is displayed")
    public void the_dashboard_is_displayed() {
        assertTrue(admin.getLoggedIN());
    }


////    Owner login
//
//    @Given("The owner is on the login page")
//    public void the_owner_is_on_the_login_page() {
//        assertFalse(owner.getLoggedIN());
//    }
//    @When("The owner enters valid credentials")
//    public void the_owner_enters_valid_credentials() {
//        owner.login("Ahmad","ahmad123");
//
//    }
//    @Then("The owner is logged in")
//    public void the_owner_is_logged_in() {
//        assertTrue(owner.getLoggedIN());
//    }
//    @Then("The owner dashboard is displayed")
//    public void the_owner_dashboard_is_displayed() {
//        assertTrue(owner.getLoggedIN());
//    }
//
//// Tenant login
//    @Given("The tenant is on the login page")
//    public void the_tenant_is_on_the_login_page() {
//        assertFalse(tenant.getLoggedIN());
//    }
//    @When("The tenant enters valid credentials")
//    public void the_tenant_enters_valid_credentials() {
//        tenant.login("Alia","alia123");
//    }
//    @Then("The tenant is logged in")
//    public void the_tenant_is_logged_in() {
//        assertTrue(tenant.getLoggedIN());
//    }
//    @Then("The tenant dashboard is displayed")
//    public void the_tenant_dashboard_is_displayed() {
//        assertTrue(tenant.getLoggedIN());
//    }

}
