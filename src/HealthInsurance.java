import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HealthInsurance extends Insurance{


    private int customerAge;

    public HealthInsurance(int customerAge,Date startDate, Date endDate){
        this.customerAge = customerAge;
        setBaseCost(20);
        setName("Saglik Sigortasi");
        setStartDate(startDate);
        setEndDate(endDate);
    }

    private int getDuration(){
        long ms = Math.abs(this.endDate.getTime() - this.startDate.getTime());
        return (int)TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public double calculate() {
        double riskRate;

        if(this.customerAge <= 25){
            riskRate = 0.1;
        }else if((this.customerAge > 25) && (this.customerAge <= 45)){
            riskRate = 0.2;
        }else if(this.customerAge > 45 && this.customerAge <= 65){
            riskRate = 0.35;
        }else{
            riskRate = 0.5;
        }

        return (riskRate + 1) * getBaseCost() * getDuration();
    }

    public String toString(){
        String startDate = (getStartDate().getYear() + 1900) + "/" + (getStartDate().getMonth() + 1) + "/" + getStartDate().getDate();
        String endDate = (getEndDate().getYear() + 1900) + "/" + (getEndDate().getMonth() + 1) + "/"  + getEndDate().getDate();
        return String.format("%-25s %-20s %-20s %-12s %-10s",getName(), startDate, endDate, getDuration(), calculate());
    }
    

}
