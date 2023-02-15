import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TravelInsurance extends Insurance{


    public TravelInsurance(Date startDate, Date endDate){
        setBaseCost(100);
        setName("Seyahat Sigortasi");
        setStartDate(startDate);
        setEndDate(endDate);
    }

    private int getDuration(){
        long ms = Math.abs(this.endDate.getTime() - this.startDate.getTime());
        return (int)TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public double calculate() {

        return getBaseCost() * getDuration();
    }

    public String toString(){
        String startDate = (getStartDate().getYear() + 1900) + "/" + (getStartDate().getMonth() + 1) + "/" + getStartDate().getDate();
        String endDate = (getEndDate().getYear() + 1900) + "/" + (getEndDate().getMonth() + 1) + "/"  + getEndDate().getDate();
        return String.format("%-25s %-20s %-20s %-12s %-10s",getName(), startDate, endDate, getDuration(), calculate());
    }

    
}
