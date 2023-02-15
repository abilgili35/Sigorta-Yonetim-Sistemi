import java.util.ArrayList;
import java.util.Date;

public abstract class Account implements Comparable<Account>{

    private AuthenticationStatus authenticationStatus;
    private User user;
    protected ArrayList<Insurance> insuranceList;
    protected double profitRate;
    private Date lastLogin;
    private Date loginTime;

    

    public Account(){
        insuranceList = new ArrayList<>();
        authenticationStatus = AuthenticationStatus.FAIL;
    }

    public Account(User user){
        setUser(user);
        insuranceList = new ArrayList<>();
        authenticationStatus = AuthenticationStatus.FAIL;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public void addAddress(String address) throws InvalidAddressException{
        AddressManager.addAddress(user, address);
    }

    public void removeAddress(int index) throws IndexOutOfBoundsException, AddressNotFoundException{
        AddressManager.removeAddress(user, index);
    }

    
    public void setUser(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public ArrayList<Insurance> getInsuranceList() {
        return insuranceList;
    }

    public void login(String email, String password) throws InvalidAuthenticationException{
        if(getUser().getEmail().equals(email) && getUser().getPassword().equals(password))
        {
            this.authenticationStatus = AuthenticationStatus.SUCCESS;
        }
        else{
            throw new InvalidAuthenticationException();
        }
    }

    public void setLoginStatus(AuthenticationStatus status){
        this.authenticationStatus = status;
    }

    public AuthenticationStatus getLoginStatus(){
        return this.authenticationStatus;
    }

    public final void showUserInfo(){
        System.out.println("\n############ Kullanici Bilgileri ##############\n");
        System.out.println(this.user.toString() + "\n");
        System.out.println("############ Adres Bilgileri     ##############\n");
        for(Address adr : this.user.getAddressList()){
            if(adr.getType() == AddressType.HOME){
                System.out.println("EV ADRESI : " + adr.toString());
            }else if(adr.getType() == AddressType.BUSINESS){
                System.out.println("IS ADRESI : " + adr.toString());
            }
        }
        
        if(this.getLastLogin() != null){
             System.out.println("\nSon Giris : " + this.getLastLogin().toString());
        }else{
            System.out.println("\nSon Giris : - ");
        }

        System.out.println();
        
    }

    public boolean equals (Object obj) {
        if (this == obj)
            return true;

        if (this == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        Account acc = (Account) obj;
        
        if(this.hashCode() == acc.hashCode()){
            return true;
        }else{
            return false;
        }
        
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
    

    @Override
    public int hashCode() {
        return this.user.getEmail().hashCode();
    }

    

    public abstract void addInsurance(Insurance insurance);

    


}
