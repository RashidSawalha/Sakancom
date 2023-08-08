import java.util.*;
import java.util.logging.*;

public class Apartments {
    Logger logger=Logger.getLogger(Apartments.class.getName());
    private int floor;
    private int apartmentID;
    private ArrayList<Tenants> tenantsArrayList;
    private int bathrooms;
    private int bedrooms;
    private boolean hasBalcony;


    public Apartments(int floor,int id, int bathrooms, int bedrooms, boolean hasBalcony) {
        this.floor = floor;
        this.apartmentID=id;
        this.tenantsArrayList = new ArrayList<>();
        this.bathrooms = bathrooms;
        this.bedrooms = bedrooms;
        this.hasBalcony = hasBalcony;
    }

    // Getters and Setters (you can generate them in your IDE or manually implement them)

    public int getFloor() {
        return floor;
    }

    public int getApartmentID(){
        return apartmentID;
    }

    public List<Tenants> getTenants() {
        return tenantsArrayList;
    }

    public int getBathrooms() {
        String message=String.format("number of bathrooms is :%d",bathrooms);
        logger.log(Level.INFO,message);
        return bathrooms;
    }

    public int getBedrooms() {
        String message=String.format("number of bedrooms is :%d",bedrooms);
        logger.log(Level.INFO,message);
        return bedrooms;
    }

    public boolean hasBalcony() {
        if (hasBalcony){
            logger.log(Level.INFO,"has a balcony");
        }
        return hasBalcony;
    }

    // Other methods related to Apartment, if needed

    public boolean addTenant(Tenants newTenant){
        for (Tenants oldTenant:tenantsArrayList) {
            if (oldTenant.getTenantID()==(newTenant.getTenantID())){
                logger.log(Level.INFO,"Tenant already exists !");
                return false;
            }
        }
        tenantsArrayList.add(newTenant);
        logger.log(Level.INFO,"Tenant has been added successfully");

        return true;
    }

    public void viewTenantsDetails(){
        String message1=String.format("Tenants of apartment number : %d",this.getApartmentID());
        logger.log(Level.INFO,message1);
        for (Tenants tenant : tenantsArrayList){
            String message2=String.format("Tenant ID : %d ,Name : %s ,phone number : %s ,email : %s",tenant.getTenantID(),tenant.getName(),tenant.getPhoneNumber(),tenant.getEmail());
            logger.log(Level.INFO,message2);
        }
    }


}
