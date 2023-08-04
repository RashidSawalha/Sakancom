import java.util.ArrayList;
import java.util.List;

public class Apartments {
    private int floor;
    private int apartmentID;
    private ArrayList<Tenants> tenantsArrayList;
    private int bathrooms;
    private int bedrooms;
    private boolean hasBalcony;

    // Constructor
//    public Apartments(int floor, int bathrooms, int bedrooms, boolean hasBalcony) {
//        this.floor = floor;
//        this.tenantsArrayList = new ArrayList<>();
//        this.bathrooms = bathrooms;
//        this.bedrooms = bedrooms;
//        this.hasBalcony = hasBalcony;
//    }
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
        return bathrooms;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    // Other methods related to Apartment, if needed

    public boolean addTenant(Tenants newTenant){
        for (Tenants oldTenant:tenantsArrayList) {
            if (oldTenant.getTenantID()==(newTenant.getTenantID())){
                System.out.println("Tenant already exists !");
                return false;
            }
        }
        tenantsArrayList.add(newTenant);
        System.out.println("Tenant has been added successfully");
        return true;
    }

    public void viewTenantsDetails(){
        System.out.println("Tenants of apartment number : " + this.getApartmentID());
        for (Tenants tenant : tenantsArrayList){
            System.out.println("Tenant ID : "+tenant.getTenantID()+" / Name : "+tenant.getName()+" / phone number : "+tenant.getPhoneNumber()+" / email : "+tenant.getEmail());
        }
    }


}
