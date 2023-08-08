import java.util.ArrayList;
import java.util.logging.*;
class Housing {
    Logger logger=Logger.getLogger(Housing.class.getName());
    private Owners owner;
    private String location;
    private String name;
    private double monthlyRent;
    private boolean isAdvertised;
    private int housingId;
    private String services;
    private boolean includesElectricityWater;
    private ArrayList<Apartments> apartmentsArrayList;

    public Housing(String location, String name, String services, double monthlyRent, boolean includesElectricityWater, int id , Owners owner ) {
        this.location = location;
        this.name = name;
        this.services=services;
        this.monthlyRent = monthlyRent;
        this.includesElectricityWater=includesElectricityWater;
        this.housingId=id;
        this.isAdvertised = false;
        this.owner=owner;
        this.apartmentsArrayList=new ArrayList<>();
    }

    public Housing(String location, String name, String services, double monthlyRent, boolean includesElectricityWater, int id , String ownerName ) {
        this.location = location;
        this.name = name;
        this.services=services;
        this.monthlyRent = monthlyRent;
        this.includesElectricityWater=includesElectricityWater;
        this.housingId=id;
        this.isAdvertised = false;
        this.owner=new Owners(ownerName);
        this.apartmentsArrayList=new ArrayList<>();
    }
    public Housing(){
        this.location = null;
        this.name = null;
        this.services=null;
        this.monthlyRent = 0;
        this.includesElectricityWater=false;
        this.housingId=0;
        this.isAdvertised = false;
        this.owner=new Owners();
        this.apartmentsArrayList=new ArrayList<>();
    }
    public Housing(Owners owner,int id){
        this.location = null;
        this.name = null;
        this.services=null;
        this.monthlyRent = 0;
        this.includesElectricityWater=false;
        this.housingId=id;
        this.isAdvertised = false;
        this.owner=owner;
        this.apartmentsArrayList=new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public boolean getAdvertised() {
        return isAdvertised;
    }

    public int getHousingId() {
        return housingId;
    }


    public Owners getOwner() {
        return owner;
    }

    public String getServices() {
        return services;
    }

    public boolean getIncludesElectricityWater() {
        return includesElectricityWater;
    }

    public ArrayList<Apartments> getApartments(int floor) {
        ArrayList<Apartments> apartmentsInTheFloor =new ArrayList<>();
        for (Apartments apartments : apartmentsArrayList){
            if (apartments.getFloor()==floor){
                apartmentsInTheFloor.add(apartments);
            }
        }

        return apartmentsInTheFloor;
    }




    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setIncludesElectricityWater(boolean includesElectricityWater) {
        this.includesElectricityWater = includesElectricityWater;
    }

    public void setAdvertised(boolean advertised) {
        isAdvertised = advertised;
    }

    public void setHousingId(int housingId) {
        this.housingId = housingId;
    }

    public void setOwner(Owners owner) {
        this.owner = owner;
    }


    public void addApartment(Apartments newApartment){
        apartmentsArrayList.add(newApartment);
        logger.log(Level.INFO,"Apartment has been added successfully");
    }

    public Apartments getApartment(int id) {
        for (Apartments apartment : apartmentsArrayList){
            if (apartment.getApartmentID()==id)
                return apartment;
        }
        return null;
    }

    public int getNumberOfTenants() {
        int totalTenants = 0;
        for (Apartments apartment : apartmentsArrayList) {
            totalTenants += apartment.getTenants().size();
        }
        return totalTenants;
    }

    public int getNumberOfApartments() {
        int totalApartments = 0;
            totalApartments+=apartmentsArrayList.size();
        return totalApartments;
    }

    public int getNumberOfFloors() {
        int numberOfFloors=0;
        for (Apartments apartment : apartmentsArrayList){
            if (apartment.getFloor()>numberOfFloors){
                numberOfFloors=apartment.getFloor();
            }
        }
        return numberOfFloors;
    }

}
