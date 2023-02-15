public class HomeAddress implements Address{

    private String city;
    private String street;
    private int buildingNo;
    private int zipCode;


    public HomeAddress(String city, String street, int buildingNo, int zipCode){
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
        this.zipCode = zipCode;
    }

    @Override
    public AddressType getType() {
        return AddressType.HOME;
    }

    @Override
    public String toString() {
        return this.street + " SOKAK NO:" + this.buildingNo + " " + this.city + " " + this.zipCode;  
    }

    
    
}
