import java.util.ArrayList;
import java.util.Date;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String job;
    private int age;
    private ArrayList<Address> addressList;
    

    public User(String name, String surname, String email, String password, String job, int age){
        setName(name);
        setSurname(surname);
        setEmail(email );
        setPassword(password);
        setJob(job);
        setAge(age);
        addressList = new ArrayList<>();
    }
    
    public void addAddress(Address address){
        addressList.add(address);
    }

    public boolean removeAddress(Address address){
        return addressList.remove(address);
    }

    public ArrayList<Address> getAddressList(){
        return this.addressList;
    }

    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        String info =  "Ad Soyad \t:\t" + this.getName() + " " + this.getSurname() + "\nIs  \t\t:\t" + this.getJob() + "\nYas \t\t:\t" + this.getAge() + "\nEmail \t\t:\t" + this.getEmail();
        return info + "\n\n";
    }
}
