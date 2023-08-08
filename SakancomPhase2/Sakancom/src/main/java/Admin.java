import java.io.*;
import java.util.*;
import java.util.logging.*;

public class Admin {
    Logger logger=Logger.getLogger(Admin.class.getName());
    private String string="Admin is not logged in. Please log in first.";
    private boolean loggedIN;

    private ArrayList<Owners> ownersArrayList;
    private ArrayList<Tenants> tenantsArrayList;
    private ArrayList<Housing> housingsArrayList;
    private ArrayList<Reservations> reservationsArrayList;
    private ArrayList<Request> requestArrayList;

    public Admin(){
        loggedIN = false;
        ownersArrayList = new ArrayList<>();
        tenantsArrayList = new ArrayList<>();
        housingsArrayList = new ArrayList<>();
        reservationsArrayList=new ArrayList<>();
        requestArrayList=new ArrayList<>();
    }


    public boolean getLoggedIN() {
        return loggedIN;
    }

    public void setLoggedIN(boolean loggedIn) {
        this.loggedIN = loggedIn;
    }

    public void login(String username, String password) {

        String filePath = "C:/Users/hp/OneDrive/Desktop/Alaa+Rashed/Sakancom/Admins.txt";

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
        if (!loggedIN){
            logger.log(Level.INFO,"Invalid username or password.");
        }
        } catch (IOException e) {
        e.printStackTrace();
        }


    }

    public boolean acceptAdvertisementRequest(int requestIndex) {
        if (loggedIN) {
            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getRequestId()==requestIndex){
                    requestArrayList.get(i).setStatus("Accepted");
                    requestArrayList.get(i).getHousing().setAdvertised(true);
                    String message=String.format("Request id : %d Accepted",requestArrayList.get(i).getRequestId());
                    logger.log(Level.INFO,message);

                }
            }
            return true;
        }
        else {
            logger.log(Level.INFO,string);
            return false;
        }
    }

    public boolean rejectAdvertisementRequest(int requestIndex) {
        if (loggedIN) {

            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getRequestId()==requestIndex){
                    requestArrayList.get(i).setStatus("Rejected");
                    requestArrayList.get(i).getHousing().setAdvertised(false);
                    String message=String.format("Request id : %d Rejected",requestArrayList.get(i).getRequestId());
                    logger.log(Level.INFO,message);

                }
            }
           return true;
        }
        else {
            logger.log(Level.INFO,"Admin is not logged in. please log in first");
            return false;
        }
    }

    public boolean advertiseHousingUnit(int housingID) {
        logger.log(Level.INFO,"Housing Unit :");
        for (Housing housing :housingsArrayList){
            if (housing.getHousingId()==housingID){
                housing.setAdvertised(true);

                String message=String.format("Housing id : %d , Owner name : %s , Description : %s , Rent : %f",housing.getHousingId(),housing.getOwner().getName(),housing.getName(),housing.getMonthlyRent());
                logger.log(Level.INFO,message);
                return true;
            }
        }
        logger.log(Level.INFO,"No Housing unit exists with entered ID , please enter a valid id.");
        return false;
    }


    public String modifyHousingData(int housingUnitID, String description , String title , double rent , boolean advertised) {
        String res ="Not found!";
        if (loggedIN) {
            for (Housing housing : housingsArrayList){
                if (housing.getHousingId()==housingUnitID){
                    housing.setName(description);
                    housing.setLocation(title);
                    housing.setMonthlyRent(rent);
                    housing.setAdvertised(advertised);
                    String message=String.format("Housing unit with ID : %d is updated successfully",housing.getHousingId());
                    logger.log(Level.INFO,message);
                    res = housing.getName();
                }
            }

            for (int i=0;i<housingsArrayList.size();i++){
                if (!housingsArrayList.get(i).getAdvertised()){
                    housingsArrayList.remove(i);
                }

            }
        } else {
            logger.log(Level.INFO,string);
            return res;
        }
        return res;
    }

    public boolean addHousing(Housing newHousing){
        for (Housing oldHousing:housingsArrayList) {
            if (oldHousing.getHousingId()==newHousing.getHousingId()){
                logger.log(Level.INFO,"Housing unit already exists !");
                return false;
            }
        }
//        for (Request request : requestArrayList){
//            if (request.getStatus().equals("Rejected") || request.getStatus().equals("Pending") ){
//                logger.log(Level.INFO,"Housing unit request is not Accepted.");
//                return false;
//            }
//        }


        housingsArrayList.add(newHousing);

            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getHousing().getHousingId()==newHousing.getHousingId()){
                    requestArrayList.remove(i);
                }
            }


        String message=String.format("Housing unit with ID : %d added successfully",newHousing.getHousingId());
        logger.log(Level.INFO,message);

        return true;
    }

    public boolean addRequest(Request newRequest){
        for (Request oldRequest:requestArrayList) {
            if (oldRequest.getRequestId()==newRequest.getRequestId()){
                logger.log(Level.INFO,"Request already exists !");
                return false;
            }
        }

        requestArrayList.add(newRequest);
        logger.log(Level.INFO,"Request added successfully");
        return true;
    }

    public boolean addReservation(Reservations newReservation){
        for (Reservations oldReservation:reservationsArrayList) {
            if (oldReservation.getTenant().getTenantID()==newReservation.getTenant().getTenantID() && oldReservation.getHousing().getHousingId()==newReservation.getHousing().getHousingId())
            {
                logger.log(Level.INFO,"Reservation already exists !");
                return false;
            }
        }
        newReservation.setReserved(true);
        reservationsArrayList.add(newReservation);
        logger.log(Level.INFO,"Reservation added successfully");
        return true;
    }

    public boolean addOwners(Owners newOwner){
        for (Owners oldOwner:ownersArrayList) {
            if (oldOwner.getName().equals(newOwner.getName())){
                logger.log(Level.INFO,"Owner already exists !");
                return false;
            }
        }
        ownersArrayList.add(newOwner);
        logger.log(Level.INFO,"Owner added successfully");
        return true;
    }

    public boolean viewRequestDetails(Request request) {
        if (loggedIN) {
            logger.log(Level.INFO,"Request Details: ");
            String message1 = String.format("Request ID : %d",request.getRequestId());
            logger.log(Level.INFO,message1);
            String message2 = String.format("Request Status : %s",request.getStatus());
            logger.log(Level.INFO,message2);
            return true;
        } else {
            logger.log(Level.INFO,string);
            return false;
        }
    }

    public boolean viewReservations() {
        int index=1;
        if (loggedIN) {
            if (reservationsArrayList.isEmpty()) {
                logger.log(Level.INFO,"No reservations found.");
            }
            else {
                logger.log(Level.INFO,"Reservations :");
                for (Reservations res : reservationsArrayList) {
                    if (res.getReserved()) {
                        String message1=String.format("%d-) Housing unit with ID : %d has a reservation for : %s",index,res.getHousing().getHousingId(),res.getTenant().getName());
                        logger.log(Level.INFO,message1);
                        index++;
                    }
                }
            }
            return true;

        } else {
            logger.log(Level.INFO,string);
            return false;
        }
    }

    public List<Housing> getHousingsArrayList() {
        return housingsArrayList;
    }

}

















