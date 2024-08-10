import java.time.LocalDate;
import java.time.LocalTime;

public class Date {
    private int day,month,year,hour,minute,second,milisecond;
    Date(int year, int month, int day){
        this.day = day;
        this.month = month;
        this.year = year;
    }
    Date(){
        this.year = LocalDate.now().getYear();
        this.month = LocalDate.now().getMonthValue();
        this.day = LocalDate.now().getDayOfMonth();
        this.hour = LocalTime.now().getHour();
        this.minute = LocalTime.now().getMinute();
        this.second = LocalTime.now().getSecond();
        this.milisecond = (int) LocalTime.now().getNano()/1000000;
    }
    public String getDate(){
        return this.day+"/"+this.month+"/"+this.year;
    }
    public String getTime(){
        return this.hour+":"+this.minute+":"+this.second+" "+this.milisecond;
    }
}
