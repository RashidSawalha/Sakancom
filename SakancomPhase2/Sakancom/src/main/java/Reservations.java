public class Reservations {
    private Tenants tenant=new Tenants();
    private Housing housing=new Housing();
    private boolean isReserved;


    public Reservations(Tenants tenant,int housingID){
        this.tenant=tenant;
        this.housing.setHousingId(housingID);
        this.isReserved=false;
    }

    public Tenants getTenant() {
        return tenant;
    }

    public void setTenant(Tenants tenant) {
        this.tenant = tenant;
    }

    public Housing getHousing() {
        return housing;
    }

    public void setHousing(Housing housing) {
        this.housing = housing;
    }

    public boolean getReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

}
