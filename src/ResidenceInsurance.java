import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ResidenceInsurance extends Insurance{

    private int residenceAge;

    public ResidenceInsurance(int residenceAge, Date startDate, Date endDate){
        this.residenceAge = residenceAge;
        setBaseCost(15);
        setName("Konut Sigortasi");
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

        if(this.residenceAge <= 10){
            riskRate = 0.1;
        }else if(this.residenceAge > 10 && this.residenceAge <= 20){
            riskRate = 0.25;
        }else{
            riskRate = 0.4;
        }

        return (riskRate + 1) * getBaseCost() * getDuration();
    }

    public String toString(){
        String startDate = (getStartDate().getYear() + 1900) + "/" + (getStartDate().getMonth() + 1) + "/" + getStartDate().getDate();
        String endDate = (getEndDate().getYear() + 1900) + "/" + (getEndDate().getMonth() + 1) + "/"  + getEndDate().getDate();
        return String.format("%-25s %-20s %-20s %-12s %-10s",getName(), startDate, endDate, getDuration(), calculate());
    }
    
}
