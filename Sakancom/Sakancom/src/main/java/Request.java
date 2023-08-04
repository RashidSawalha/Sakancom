public class Request {


    private int requestId;
    private String status;
    private Housing housing;

    public Request(int requestId ) {
        this.requestId = requestId;
        this.status = "Pending";
        this.housing=null;
    }

    public Request (int requestId,Housing housing){
        this.requestId=requestId;
        this.housing=housing;
        this.status="Pending";
    }

    public int getRequestId() {
        return requestId;
    }

    public Housing getHousing() {
        return housing;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }


}
