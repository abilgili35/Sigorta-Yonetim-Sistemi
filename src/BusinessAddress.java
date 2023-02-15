public class BusinessAddress implements Address{

    

    private String companyName;
    private String city;
    private String street;
    private int buildingNo;
    private int zipCode;

    public BusinessAddress(String companyName, String city, String street, int buildingNo, int zipCode){
        setCompanyName(companyName);
        this.city = city;
        this.street = street;
        this.buildingNo = buildingNo;
        this.zipCode = zipCode;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    @Override
    public AddressType getType() {
        return AddressType.BUSINESS;
    }

    @Override
    public String toString() {
        return this.street + " SOKAK NO:" + this.buildingNo + " " + this.city + " " + this.zipCode + " " + this.getCompanyName().toUpperCase();  
    }

    

    
}
