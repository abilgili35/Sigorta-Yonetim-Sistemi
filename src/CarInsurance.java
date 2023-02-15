import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CarInsurance extends Insurance{
    
    private int carAge;
    private int km;

    public CarInsurance(int carAge,int km, Date startDate, Date endDate){
        this.carAge = carAge;
        this.km = km;
        setBaseCost(15);
        setName("Arac Sigortasi");
        setStartDate(startDate);
        setEndDate(endDate);
    }

    private int getDuration(){
        long ms = Math.abs(this.endDate.getTime() - this.startDate.getTime());
        return (int)TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public double calculate() {
        double riskRate = 0;

        if(this.carAge > 5 && this.carAge <= 10){
            riskRate += 0.1;
        }else if((this.carAge > 10) && (this.carAge <= 20)){
            riskRate += 0.2;
        }else if(this.carAge > 30 && this.carAge <= 40){
            riskRate += 0.35;
        }else{
            riskRate += 0.5;
        }

        if(this.km > 25000 && this.km <= 50000 ){
            riskRate += 0.1;
        }else if(this.km > 50000 && this.km <= 100000){
            riskRate += 0.2;
        }else if(this.km > 100000 && this.km < 200000){
            riskRate += 0.3;
        }else{
            riskRate += 0.5;
        }

        return (riskRate+ 1) * getBaseCost() * getDuration();
    }

    public String toString(){
        String startDate = (getStartDate().getYear() + 1900) + "/" + (getStartDate().getMonth() + 1) + "/" + getStartDate().getDate();
        String endDate = (getEndDate().getYear() + 1900) + "/" + (getEndDate().getMonth() + 1) + "/"  + getEndDate().getDate();
        return String.format("%-25s %-20s %-20s %-12s %-10s",getName(), startDate, endDate, getDuration(), calculate());
    }
    
    
}
