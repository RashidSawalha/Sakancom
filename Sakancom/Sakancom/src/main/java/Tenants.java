import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tenants {
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

    public void setLoggedIN(boolean logged_in) {
        this.loggedIN = logged_in;
    }

    public void login(String username, String password) {
        // Code to validate credentials and log in the system administrator

        String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Alaa+Rashed\\Sakancom\\Tenant.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                for (int i=0;i<values.length;i+=2){
                    if (username.equals(values[i]) && password.equals(values[i+1])) {
                        setLoggedIN(true);
                        System.out.println("Logged in successfully.");
                        break;
                    }
                }
            }
            if (!loggedIN)
                System.out.println("Invalid username or password.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void viewAvailableHousingUnits(Admin admin){
        for (Housing option  : admin.getHousingsArrayList()){
            System.out.println("------------------------------");
            System.out.println("Location: " + option.getLocation());
            System.out.println("Name : " + option.getName());
            System.out.println("------------------------------");
        }
    }

    public void viewSelectedHousingDetails(int housingID , Admin admin){
        for (Housing housing  : admin.getHousingsArrayList()){
           if (housing.getHousingId()==housingID){
               System.out.println("------------------------------");
               System.out.println("Owner Name: " + housing.getOwner().getName());
               System.out.println("Location: " + housing.getLocation());
               System.out.println("Name : " + housing.getName());
               System.out.println("Price: $" + housing.getMonthlyRent());
               System.out.println("Services: " + housing.getServices());
               System.out.println("Number of Apartments : "+ housing.getNumberOfApartments());
               System.out.println("Number of Tenants : "+ housing.getNumberOfTenants());
               System.out.println("------------------------------");
           }
        }
    }public boolean bookAccommodation(Admin admin,Housing housing,Apartments apartment){
        for (Housing housing1 : admin.getHousingsArrayList()){
            if (housing1.getHousingId()==housing.getHousingId()){
                if (housing1.getApartment(apartment.getApartmentID())==apartment){
                    housing1.getApartment(apartment.getApartmentID()).addTenant(this);
                    System.out.println("you have booked this apartment .");
                    return true;
                }
            }
        }
        return false;
    }


    public void TenantControlPanel(Admin admin,Housing housing,Apartments apartment){
        System.out.println("------------------------------");
        System.out.println("Tenant control panel :");
        System.out.println("Tenant name : "+this.getName());
        System.out.println("Tenant contact info : 1-)phone number :- "+ this.getPhoneNumber()+" , 2-) email :- "+this.getEmail());
        System.out.println("Owner name : "+housing.getOwner().getName());
        System.out.println("Owner contact info : 1-)phone number :- "+ housing.getOwner().getPhoneNumber()+" , 2-)email :- "+housing.getOwner().getEmail());
        System.out.println("you must pay ("+housing.getMonthlyRent()+") on the first of each month");
    }
}
