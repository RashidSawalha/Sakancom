import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Admin {

    private boolean loggedIN;
//    private String userName,password;

    private ArrayList<Owners> ownersArrayList;
    private ArrayList<Tenants> tenantsArrayList;
    private ArrayList<Housing> housingsArrayList;
    private ArrayList<Reservations> reservationsArrayList;
    private ArrayList<Request> requestArrayList;

    public Admin(){
//        userName="";
//        password="";
        loggedIN = false;
        ownersArrayList = new ArrayList<>();
        tenantsArrayList = new ArrayList<>();
        housingsArrayList = new ArrayList<>();
        reservationsArrayList=new ArrayList<>();
        requestArrayList=new ArrayList<>();
    }


//    public String getUserName() {
//        return userName;
//    }
//    public String getPassword() {
//        return password;
//    }
    public boolean getLoggedIN() {
        return loggedIN;
    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//    public void setPassword(String password) {
//        this.password = password;
//    }
    public void setLoggedIN(boolean logged_in) {
        this.loggedIN = logged_in;
    }

    public void login(String username, String password) {
        // Code to validate credentials and log in the system administrator

        String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Alaa+Rashed\\Sakancom\\Admins.txt";

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

    public boolean acceptAdvertisementRequest(int requestIndex) {
        // Code to accept the request for housing advertisement
        if (loggedIN) {
//            Request request = housingsArrayList.get(requestIndex-1).getRequest();
            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getRequestId()==requestIndex){
                    requestArrayList.get(i).setStatus("Accepted");
                    requestArrayList.get(i).getHousing().setAdvertised(true);
                    System.out.println("Request id : " + requestArrayList.get(i).getRequestId() + " Accepted.");

                }
            }
            return true;
        }
        else {
            System.out.println("Admin is not logged in. Please log in first.");
            return false;
        }
    }

    public boolean rejectAdvertisementRequest(int requestIndex) {
        // Code to accept the request for housing advertisement
        if (loggedIN) {
//            Request request = housingsArrayList.get(requestIndex-1).getRequest();
            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getRequestId()==requestIndex){
                    requestArrayList.get(i).setStatus("Rejected");
                    requestArrayList.get(i).getHousing().setAdvertised(false);
                    System.out.println("Request id : " + requestArrayList.get(i).getRequestId() + " Rejected.");

                }
            }
           return true;
        }
        else {
            System.out.println("Admin is not logged in. Please log in first.");
            return false;
        }
    }

    public boolean advertiseHousingUnit(int housingID) {
        // Code to advertise the housing unit
        System.out.println("Housing Unit : ");
        for (Housing housing :housingsArrayList){
            if (housing.getHousingId()==housingID){
                housing.setAdvertised(true);
                System.out.println("Housing ID : "+housing.getHousingId()+", Owner name : "+housing.getOwner().getName()+", Description : "+housing.getName()+", Rent : "+housing.getMonthlyRent()+".");
                return true;
            }
        }
        System.out.println("No Housing unit exists with entered ID , please enter a valid id.");
        return false;
    }


    public String modifyHousingData(int housingUnitID, String description , String title , double rent , boolean advertised) {
        // Code to modify housing data
        String res ="Not found!";
        if (loggedIN) {
            for (Housing housing : housingsArrayList){
                if (housing.getHousingId()==housingUnitID){
                    housing.setName(description);
                    housing.setLocation(title);
                    housing.setMonthlyRent(rent);
                    housing.setAdvertised(advertised);
                    System.out.println("Housing unit with ID : "+housing.getHousingId()+ " is updated successfully");
                    res = housing.getName();
                }
            }

//            for each to delete the not advertised housing unit from the array
            for (int i=0;i<housingsArrayList.size();i++){
                if (!housingsArrayList.get(i).getAdvertised()){
                    housingsArrayList.remove(i);
                }

            }
//            for (Housing oldHousing:housingsArrayList) {
//                System.out.println(oldHousing.getHousingId()+" / "+oldHousing.getDescription()+" / "+oldHousing.getMonthlyRent());
//            }
        } else {
            System.out.println("Admin is not logged in. Please log in first.");
            return res;
        }
        return res;
    }

    public boolean addHousing(Housing newHousing){
        for (Housing oldHousing:housingsArrayList) {
            if (oldHousing.getHousingId()==newHousing.getHousingId()){
                System.out.println("Housing unit already exists !");
                return false;
            }
        }
        for (Request request : requestArrayList){
            if (request.getStatus().equals("Rejected") || request.getStatus().equals("Pending") ){
                System.out.println("Housing unit request is not Accepted.");
                return false;
            }
        }

//        for (Request request : requestArrayList){
//            System.out.println(request.getRequestId());
//        }

        housingsArrayList.add(newHousing);

            for (int i=0;i<requestArrayList.size();i++){
                if (requestArrayList.get(i).getHousing().getHousingId()==newHousing.getHousingId()){
                    requestArrayList.remove(i);
                }
            }

//        for (Request request : requestArrayList){
//            System.out.println(request.getRequestId());
//            }

        System.out.println("Housing unit with ID : "+newHousing.getHousingId()+"  added successfully");
        return true;
    }

    public boolean addRequest(Request newRequest){
        for (Request oldRequest:requestArrayList) {
            if (oldRequest.getRequestId()==newRequest.getRequestId()){
                System.out.println("Request already exists !");
                return false;
            }
        }

        requestArrayList.add(newRequest);
        System.out.println("Request added successfully");
        return true;
    }

    public boolean addReservation(Reservations newReservation){
        for (Reservations oldReservation:reservationsArrayList) {
            if (oldReservation.getTenant().getTenantID()==newReservation.getTenant().getTenantID() && oldReservation.getHousing().getHousingId()==newReservation.getHousing().getHousingId())
            {
                System.out.println("Reservation already exists !");
                return false;
            }
        }
        newReservation.setReserved(true);
        reservationsArrayList.add(newReservation);
        System.out.println("Reservation added successfully");
        return true;
    }

    public boolean addOwners(Owners newOwner){
        for (Owners oldOwner:ownersArrayList) {
            if (oldOwner.getName()==(newOwner.getName())){
                System.out.println("Owner already exists !");
                return false;
            }
        }
        ownersArrayList.add(newOwner);
        System.out.println("Owner added successfully");
        return true;
    }

    public boolean viewRequestDetails(Request request) {
        // Simulate viewing request details
        if (loggedIN) {
            System.out.println("Request Details: ");
            System.out.println("Request ID: " + request.getRequestId());
            System.out.println("Request Status: " + request.getStatus());
            return true;
        } else {
            System.out.println("Admin is not logged in. Please log in first.");
            return false;
        }
    }

    public boolean viewReservations() {
        // Simulate viewing request details
        int index=1;
        if (loggedIN) {
            if (reservationsArrayList.isEmpty()) {
                System.out.println("No reservations found.");
            }
            else {
                System.out.println("Reservations :");
                for (Reservations res : reservationsArrayList) {
                    if (res.getReserved()) {
                        System.out.println(index + "-) Housing unit with ID : " + res.getHousing().getHousingId() + " is reserved for : " + res.getTenant().getName());
                        index++;
                    }
                }
            }
            return true;

        } else {
            System.out.println("Admin is not logged in. Please log in first.");
            return false;
        }
    }

    public ArrayList<Housing> getHousingsArrayList() {
        return housingsArrayList;
    }

}
















//login alternative functionality:
//String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Alaa+Rashed\\Sakancom\\Admins.txt";
//
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//                String line;
//                while ((line = reader.readLine()) != null) {
//                String[] values = line.split(",");
//                for (int i=0;i<values.length;i+=2){
//        if (username.equals(values[i]) && password.equals(values[i+1])) {
//        setLoggedin(true);
//        System.out.println("Logged in successfully.");
//        break;
//        }
//        }
//        }
//        if (!loggedin)
//        System.out.println("Invalid username or password.");
//        } catch (IOException e) {
//        e.printStackTrace();
//        }



//        if (username.equals("Admin") && password.equals("Admin123")) {
//            setLoggedin(true) ;
//            System.out.println("Logged in successfully.");
//        } else {
//            System.out.println("Invalid username or password.");
//        }

// add housing --------------------------------------------------------------------------***
//for (Housing oldHousing:housingsArrayList) {
//        if (oldHousing.getHousingId()==newHousing.getHousingId()){
//        System.out.println("Housing unit already exists !");
//        return false;
//        }
//        }
//
//        housingsArrayList.add(newHousing);
//        System.out.println("Housing unit added successfully");
//        return true;
