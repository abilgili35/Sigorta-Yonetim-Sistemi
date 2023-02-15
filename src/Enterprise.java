public class Enterprise extends Account{

    public Enterprise(User user){
        super(user);
        setProfitRate(0.1);
    }

    @Override
    public void addInsurance(Insurance insurance) {
        insurance.setCost(insurance.calculate()*(1+getProfitRate()));
        this.insuranceList.add(insurance);
    }

    @Override
    public int compareTo(Account o) {
        return this.getUser().getEmail().compareTo(o.getUser().getEmail());
    }
    
}
