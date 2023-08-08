import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tenants {

    Logger logger =Logger.getLogger(Tenants.class.getName());
    private String line0 = "------------------------------";

    private String name;
    private String email;
    private String phoneNumber;
    private int tenantID;
    private boolean loggedIN;

    public Tenants(String name,String email,String phoneNumber ,int id){
        this.name= name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.tenantID=id;
    }

    public Tenants(String name,int id){
        this.name= name;
        this.tenantID=id;
    }

    public  Tenants(){
    }

    public int getTenantID() {
        return tenantID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean getLoggedIN() {
        return loggedIN;
    }


    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLoggedIN(boolean loggedIN) {
        this.loggedIN = loggedIN;
    }

    public void login(String username, String password) {
        // Code to validate credentials and log in the system administrator

        String filePath = "C:/Users/hp/OneDrive/Desktop/Alaa+Rashed/Sakancom/Tenant.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (int i=0;i<values.length;i+=2){
                    if (username.equals(values[i]) && password.equals(values[i+1])) {
                        setLoggedIN(true);

                        logger.log(Level.INFO,"Logged in successfully.");
                        break;
                    }
                }
            }
            if (!loggedIN) {
                logger.log(Level.INFO, "Invalid username or password.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void viewAvailableHousingUnits(Admin admin){
        for (Housing option  : admin.getHousingsArrayList()){
            logger.log(Level.INFO, line0);
            String message1 = String.format("Location : %s",option.getLocation());
            String message2 = String.format("Name : %s",option.getName());
            logger.log(Level.INFO,message1);
            logger.log(Level.INFO,message2);
            logger.log(Level.INFO, line0);
        }
    }

    public void viewSelectedHousingDetails(int housingID , Admin admin){
        for (Housing housing  : admin.getHousingsArrayList()){
           if (housing.getHousingId()==housingID){
               logger.log(Level.INFO, line0);
               String message1=String.format("Owner Name: %s " , housing.getOwner().getName());
               String message2=String.format("Location: %s " , housing.getLocation());
               String message3=String.format("Name : %s " , housing.getName());
               String message4=String.format("Price: $ %f " , housing.getMonthlyRent());
               String message5=String.format("Services: %s " , housing.getServices());
               String message6=String.format("Number of Apartments : %d ", housing.getNumberOfApartments());
               String message7=String.format("Number of Tenants : %d ", housing.getNumberOfTenants());
               logger.log(Level.INFO,message1);
               logger.log(Level.INFO,message2);
               logger.log(Level.INFO,message3);
               logger.log(Level.INFO,message4);
               logger.log(Level.INFO,message5);
               logger.log(Level.INFO,message6);
               logger.log(Level.INFO,message7);
           }
        }
    }
    public boolean bookAccommodation(Admin admin,Housing housing,Apartments apartment){
        for (Housing housing1 : admin.getHousingsArrayList()){
            if (housing1.getHousingId()==housing.getHousingId()&&housing1.getApartment(apartment.getApartmentID()) == apartment) {
                    housing1.getApartment(apartment.getApartmentID()).addTenant(this);
                    logger.log(Level.INFO,"you have booked this apartment .");
                    return true;
            }

        }
        return false;
    }


    public void TenantControlPanel(Housing housing){
        logger.log(Level.INFO, line0);
        logger.log(Level.INFO,"Tenant control panel :");

        String message1=String.format("Tenant name : %s ",this.getName());
        String message2=String.format("Tenant contact info : 1-)phone number :- %s , 2-) email :- %s",this.getPhoneNumber(),this.getEmail());
        String message3=String.format("Owner name : %s",housing.getOwner().getName());
        String message4=String.format("Owner contact info : 1-)phone number :- %s , 2-) email :- %s", housing.getOwner().getPhoneNumber(),housing.getOwner().getEmail());
        String message5=String.format("you must pay (%f) on the first of each month",housing.getMonthlyRent());

        logger.log(Level.INFO, message1);
        logger.log(Level.INFO, message2);
        logger.log(Level.INFO, message3);
        logger.log(Level.INFO, message4);
        logger.log(Level.INFO, message5);
    }
}
