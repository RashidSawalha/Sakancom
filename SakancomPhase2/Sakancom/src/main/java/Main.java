import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String [] args){
        Logger logger=Logger.getLogger(Main.class.getName());

        Admin admin=new Admin();

        Owners owner1 =new Owners("Ahmad","ahmad@gmail.com","0255876632");
        Owners owner2 =new Owners("Ali","ali@gmail.com","0255876602");

        Tenants tenant1=new Tenants("Alia","alia@gg.com","0599887766",1);
        Tenants tenant2=new Tenants("Pedri","pedri@gg.com","0987654321",2);
        Tenants tenant3=new Tenants("Saeed","saeed@gg.com","0599123365",3);
        Tenants tenant4=new Tenants("Musa","musa@gg.com","0577846632",4);
        Tenants tenant5=new Tenants("Gavi","gavi@gg.com","1234567890",5);
        Tenants tenant6=new Tenants("Sami","sami@gg.com","0598765532",6);
        Tenants tenant7=new Tenants("Samar","Samar@gg.com","0599887766",7);
        Tenants tenant8=new Tenants("Roa","Roa@gg.com","0987654322",8);
        Tenants tenant9=new Tenants("Rami","rami@gg.com","0599123965",9);
        Tenants tenant10=new Tenants("Keven","keven@gg.com","0577746632",10);
        Tenants tenant11=new Tenants("Mani","mani@gg.com","1234560890",11);
        Tenants tenant12=new Tenants("Salah","salah@gg.com","0598365532",612);

        Housing housing1=new Housing("Asira","g","Parking",100,true,1,owner1);
        Housing housing2=new Housing("Asira","gg","Elevator",200,true,2,owner1);
        Housing housing3=new Housing("Asira","ggg","Parking / Elevator",300,true,3,owner2);
        Housing housing4=new Housing("Asira","gggg","Gym / Pool / Parking",400,true,4,owner2);

        Apartments apartment1 = new Apartments(1,1,2,3,true);
        Apartments apartment2 = new Apartments(2,2,2,2,true);
        Apartments apartment3 = new Apartments(1,3,2,3,true);
        Apartments apartment4 = new Apartments(2,4,2,2,true);
        Apartments apartment5 = new Apartments(1,5,2,3,true);
        Apartments apartment6 = new Apartments(2,6,2,2,true);
        Apartments apartment7 = new Apartments(1,7,3,4,false);
        Apartments apartment8 = new Apartments(2,8,3,3,false);

        Request req1;
        Request req2;
        Request req3;
        Request req4;

        Reservations reservation1 = new Reservations(tenant1,housing1.getHousingId());
        Reservations reservation2 = new Reservations(tenant2,housing1.getHousingId());
        Reservations reservation3 = new Reservations(tenant3,housing2.getHousingId());
        Reservations reservation4 = new Reservations(tenant4,housing2.getHousingId());
        Reservations reservation5 = new Reservations(tenant5,housing2.getHousingId());
        Reservations reservation6 = new Reservations(tenant7,housing3.getHousingId());
        Reservations reservation7 = new Reservations(tenant8,housing3.getHousingId());
        Reservations reservation8 = new Reservations(tenant9,housing3.getHousingId());
        Reservations reservation9 = new Reservations(tenant10,housing3.getHousingId());
        Reservations reservation10 = new Reservations(tenant11,housing4.getHousingId());
        Reservations reservation11 = new Reservations(tenant12,housing4.getHousingId());

        admin.login("Alaa","alaa123");

        owner1.login(owner1.getName(), owner1.getName().toLowerCase(Locale.ROOT)+"123");
        owner2.login(owner2.getName(), owner2.getName().toLowerCase(Locale.ROOT)+"123");

        housing1.addApartment(apartment1);
        apartment1.addTenant(tenant1);
        housing1.addApartment(apartment2);
        apartment2.addTenant(tenant2);

        housing2.addApartment(apartment3);
        apartment3.addTenant(tenant3);
        apartment3.addTenant(tenant4);
        housing2.addApartment(apartment4);
        apartment4.addTenant(tenant5);
        apartment4.addTenant(tenant6);

        housing3.addApartment(apartment5);
        apartment5.addTenant(tenant7);
        apartment5.addTenant(tenant8);
        housing3.addApartment(apartment6);
        apartment6.addTenant(tenant9);

        housing4.addApartment(apartment7);
        apartment7.addTenant(tenant11);
        housing4.addApartment(apartment8);
        apartment8.addTenant(tenant12);

        owner1.addHousing(housing1);
        owner1.addHousing(housing2);
        owner2.addHousing(housing3);
        owner2.addHousing(housing4);

        req1=new Request(1,housing1);
        req2=new Request(2,housing2);
        req3=new Request(3,housing3);
        req4=new Request(4,housing4);

        admin.addRequest(req1);
        admin.addRequest(req2);
        admin.addRequest(req3);
        admin.addRequest(req4);

        admin.acceptAdvertisementRequest(1);
        admin.acceptAdvertisementRequest(2);
        admin.acceptAdvertisementRequest(3);
        admin.rejectAdvertisementRequest(4);

        admin.viewRequestDetails(req1);
        admin.viewRequestDetails(req2);
        admin.viewRequestDetails(req3);
        admin.viewRequestDetails(req4);

        admin.addReservation(reservation1);
        admin.addReservation(reservation2);
        admin.addReservation(reservation3);
        admin.addReservation(reservation4);
        admin.addReservation(reservation5);
        admin.addReservation(reservation6);
        admin.addReservation(reservation7);
        admin.addReservation(reservation8);
        admin.addReservation(reservation9);
        admin.addReservation(reservation10);
        admin.addReservation(reservation11);

        admin.viewReservations();


        admin.addHousing(housing1);
        admin.addHousing(housing2);
        admin.addHousing(housing3);
        admin.addHousing(housing4);

        admin.advertiseHousingUnit(1);
        admin.advertiseHousingUnit(2);
        admin.advertiseHousingUnit(3);
        admin.advertiseHousingUnit(4);

        admin.modifyHousingData(housing1.getHousingId(), "welcome","GGGGGG",150,true);

        String s1=String.format("The number of tenants in housing %d is %d tenants",housing2.getHousingId(),owner1.getHousingUnit(housing2.getHousingId()).getNumberOfTenants());
        logger.log(Level.INFO,s1);
        String s2=String.format("The number of floors in housing %d is %d floors",housing2.getHousingId(),owner1.getHousingUnit(housing2.getHousingId()).getNumberOfFloors());
        logger.log(Level.INFO,s2);

        ArrayList<Apartments> actual=owner1.getHousingUnit(housing2.getHousingId()).getApartments(2);
//        for (Apartments apartment : actual){
//            int index=1;
//            System.out.println(index+"-) apartment id :"+apartment.getApartmentID());
//        }

        owner1.getHousingUnit(housing2.getHousingId()).getApartment(apartment4.getApartmentID()).viewTenantsDetails();

        owner1.getHousingUnit(housing2.getHousingId()).getApartment(apartment4.getApartmentID()).getBathrooms();
        owner1.getHousingUnit(housing2.getHousingId()).getApartment(apartment4.getApartmentID()).getBedrooms();
        owner1.getHousingUnit(housing2.getHousingId()).getApartment(apartment4.getApartmentID()).hasBalcony();

        tenant6.login(tenant6.getName(), tenant6.getName().toLowerCase(Locale.ROOT)+"123");
        tenant6.viewAvailableHousingUnits(admin);
        tenant6.viewSelectedHousingDetails(housing1.getHousingId(),admin);
        tenant6.bookAccommodation(admin,housing1,apartment1);
        tenant6.TenantControlPanel(housing1);
    }
}
