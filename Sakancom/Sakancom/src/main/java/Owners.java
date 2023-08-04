import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Owners {

    private String name;
    private String email;
    private String phoneNumber;
    private boolean loggedIN;
    private ArrayList<Housing> housingsArrayList;
    private ArrayList<Request> requestArrayList;



    public Owners(String name,String email,String phoneNumber){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.loggedIN=false;
        housingsArrayList=new ArrayList<>();
        requestArrayList=new ArrayList<>();
    }

    public Owners(String name){
        this.name=name;
        this.email=null;
        this.phoneNumber=null;
        this.loggedIN=false;
        housingsArrayList=new ArrayList<>();
        requestArrayList=new ArrayList<>();
    }

    public Owners(){
        this.name=null;
        this.email=null;
        this.phoneNumber=null;
        this.loggedIN=false;
        housingsArrayList=new ArrayList<>();
        requestArrayList=new ArrayList<>();
    }

    public String getName() {
        return name;
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

    public Housing getHousingUnit(int id){
        for (Housing oldHousing:housingsArrayList) {
            if (oldHousing.getHousingId()==id){
                return oldHousing;
            }
        }
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLoggedIN(boolean logged_in) {
        this.loggedIN = logged_in;
    }



    public void login(String username, String password) {
        // Code to validate credentials and log in the system administrator

        String filePath = "C:\\Users\\hp\\OneDrive\\Desktop\\Alaa+Rashed\\Sakancom\\Owners.txt";

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

    public boolean addHousing(Housing newHousing){
        for (Housing oldHousing:housingsArrayList) {
            if (oldHousing.getHousingId()==newHousing.getHousingId()){
                System.out.println("Housing unit already exists !");
                return false;
            }
        }
        housingsArrayList.add(newHousing);
        System.out.println("Housing unit with ID : "+newHousing.getHousingId()+"  added successfully");
        return true;
    }

    public ArrayList<Housing> getHousingsArrayList(){
        return housingsArrayList;
    }


}
